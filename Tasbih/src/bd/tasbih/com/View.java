package bd.tasbih.com;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class View extends SurfaceView implements Callback {
       Context context;
       SurfaceHolder surfaceHolder;
       DrawingThread drawingThread;
	public View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context=context;
		surfaceHolder=getHolder();
		surfaceHolder.addCallback(this);
		drawingThread=new DrawingThread(this,context);
	}

	public View(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.context=context;
		surfaceHolder=getHolder();
		surfaceHolder.addCallback(this);
		drawingThread=new DrawingThread(this,context);
	}

	public View(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.context=context;
		surfaceHolder=getHolder();
		surfaceHolder.addCallback(this);
		drawingThread=new DrawingThread(this,context);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		try{drawingThread.start();}
		catch(Exception e){restartTread();}
	}

	private void restartTread() {
		// TODO Auto-generated method stub
		drawingThread.stopThread();
		drawingThread=null;
		drawingThread=new DrawingThread(this, context);
		drawingThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		drawingThread.stopThread();
	}

}
