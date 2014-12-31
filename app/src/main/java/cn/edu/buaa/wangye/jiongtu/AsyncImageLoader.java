package cn.edu.buaa.wangye.jiongtu;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AsyncImageLoader {

	private HashMap<String, SoftReference<InputStream>> streamCache;
	public static String folder_base = "/sdcard/JiongTu/";
	private static AsyncImageLoader obj;

	private AsyncImageLoader() {

        streamCache = new HashMap<String, SoftReference<InputStream>>();
        File file = new File(folder_base);
        if(!file.exists()){
            file.mkdirs();
        }
	}

	public static AsyncImageLoader createObject() {
		if (obj == null)
			obj = new AsyncImageLoader();
		return obj;
	}


	public boolean loadInputStream(final String imageUrl,
			final FileCallback fileCallback) {
        if (streamCache.containsKey(imageUrl)) {
            SoftReference<InputStream> softReference = streamCache
                    .get(imageUrl);
            InputStream is = softReference.get();
            if (is != null) {
                fileCallback.fileLoaded(is, imageUrl);
                return true;
            }
        }
		File inputFile = new File(folder_base + imageUrl.hashCode());
		if (inputFile.exists()) {
			InputStream is = null;
			try {
				is = new FileInputStream(inputFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fileCallback.fileLoaded(is, imageUrl);
			return true;
		}
		final Handler handler = new Handler() {
			public void handleMessage(Message message) {
				fileCallback.fileLoaded((InputStream) message.obj, imageUrl);
			}
		};
		new Thread() {
			@Override
			public void run() {
				InputStream is = loadInputStreamFromUrl(imageUrl);
				if (is == null)
					return;
				new Thread(new WriteInputStreamToSdcard(is, imageUrl)).start();
				Message message = handler.obtainMessage(0, is);
				handler.sendMessage(message);
			}
		}.start();
		return false;
	}

    public boolean loadInputStream(final String imageUrl,
                                   final FileCallback2 fileCallback) {

        File inputFile = new File(folder_base + imageUrl.hashCode());
        if (inputFile.exists()) {

            fileCallback.fileLoaded(folder_base + imageUrl.hashCode(), imageUrl);
            return true;
        }
        final Handler handler = new Handler() {
            public void handleMessage(Message message) {
                fileCallback.fileLoaded((String) message.obj, imageUrl);
            }
        };
        new Thread() {
            @Override
            public void run() {
                InputStream is = loadInputStreamFromUrl(imageUrl);
                if (is == null)
                    return;
                try {

                    byte[] bs = new byte[1024];
                    // 读取到的数据长度
                    int len;
                    // 输出的文件流
                    OutputStream os = new FileOutputStream(folder_base
                            + imageUrl.hashCode());
                    // 开始读取
                    while ((len = is.read(bs)) != -1) {
                        os.write(bs, 0, len);
                    }
                    // 完毕，关闭所有链接
                    os.close();
                    is.close();

                    Message message = handler.obtainMessage(0, folder_base
                            + imageUrl.hashCode());
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start();
        return false;
    }

	private static InputStream loadInputStreamFromUrl(String url) {
		if (url == null)
			return null;
		URL m;
		InputStream i = null;
		try {
			m = new URL(url);
			i = (InputStream) m.getContent();

		} catch (MalformedURLException e1) {
			// e1.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
		return i;
	}

	public interface FileCallback {
		public void fileLoaded(InputStream imageInputStream, String imageUrl);
	}

    public interface FileCallback2 {
        public void fileLoaded(String filename, String imageUrl);
    }

	public class WriteToSdcard implements Runnable {
		private BitmapDrawable d;
		private String url;

		public WriteToSdcard(BitmapDrawable d, String url) {
			this.d = d;
			this.url = url;
		}

		@Override
		public void run() {
			try {
				FileOutputStream fw = new FileOutputStream(folder_base
						+ url.hashCode());
				BufferedOutputStream out = new BufferedOutputStream(fw);
				d.getBitmap().compress(Bitmap.CompressFormat.JPEG, 80, out);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public class WriteInputStreamToSdcard implements Runnable {
		private InputStream is;
		private String url;

		public WriteInputStreamToSdcard(InputStream d, String url) {
			this.is = d;
			this.url = url;
		}

		@Override
		public void run() {
			try {
				FileOutputStream fw = new FileOutputStream(folder_base
						+ url.hashCode());
				int bytesWritten = 0;
				int byteCount = 0;
				byte[] bytes = new byte[1024];
				while ((byteCount = is.read(bytes)) != -1){
					fw.write(bytes, bytesWritten, byteCount);
					bytesWritten += byteCount;
				}
				is.close();
				fw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}