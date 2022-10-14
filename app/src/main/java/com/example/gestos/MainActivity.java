package com.example.gestos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Toast.makeText(this, "onDown", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Toast.makeText(this, "onShowPress", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Toast.makeText(this, "onSingleTapUp", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float vx, float vy) {
        float dx = motionEvent.getX() - motionEvent1.getX();
        float dy = motionEvent.getY() - motionEvent1.getY();

        if(Math.abs(dx) > Math.abs(dy)) {
            scrollHorizontal(dx, vx);
        } else {
            scrollVertical(dy, vy);
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Toast.makeText(this, "onLongPress", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Toast.makeText(this, "onFling", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Toast.makeText(this, "onSingleTapComfirmed", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onSingleTapComfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Toast.makeText(this, "onDoubleTap", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Toast.makeText(this, "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), "onDoubleTapEvent");
        return true;
    }

    private void scrollHorizontal(float diferencial, float velocidad) {
        String data = "Scroll ";
        data += diferencial>0? "izquierda" : "derecha";
        data += ", velocidad " + velocidad;

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), data);
    }

    private void scrollVertical(float diferencial, float velocidad) {
        String data = "Scroll ";
        data += diferencial>0? "arriba" : "abajo";
        data += ", velocidad " + velocidad;

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        Log.d(this.getClass().getName(), data);
    }

}