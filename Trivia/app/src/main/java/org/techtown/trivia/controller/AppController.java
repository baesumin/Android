package org.techtown.trivia.controller;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    private static AppController instance;
    private RequestQueue requestQueue;
//    private ImageLoader imageLoader;
//    private static Context ctx;

//    private AppController(Context context) {
//        ctx = context;
//        requestQueue = getRequestQueue();
//
//        imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
//            private final LruCache<String, Bitmap> cache = new LruCache<>(20);
//
//            @Override
//            public Bitmap getBitmap(String url) {
//                return cache.get(url);
//            }
//
//            @Override
//            public void putBitmap(String url, Bitmap bitmap) {
//                cache.put(url, bitmap);
//            }
//        });
//    }

    public static synchronized AppController getInstance(/* Context context */) {
//        if (instance == null) {
//            instance = new AppController(context);
//        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

//    public ImageLoader getImageLoader() {
//        return imageLoader;
//    }


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
