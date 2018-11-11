package bd.tasbih.com;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class DrawingThread extends Thread {
     int displayX,displayY;
	  private Canvas canvas;
      private View view;
      private Context context;
      
      boolean threadFlag=false;
      Bitmap backgroundBitmap;
      
      public DrawingThread( View view, Context context) {
  		super();
  		
  		this.view = view;
  		this.context = context;
  		
  		initializeAll();
  	}
      private  void initializeAll(){
    	  WindowManager windowManager=(WindowManager)context.getSystemService(context.WINDOW_SERVICE);
    	  Display defaultDisplay=windowManager.getDefaultDisplay();
    	  Point displayDimension=new Point();
    	  defaultDisplay.getSize(displayDimension);
    	  displayX=displayDimension.x;
    	  displayY=displayDimension.y;
    	  backgroundBitmap=BitmapFactory.decodeResource(context.getResources(),R.drawable.kalema1 );
    	  backgroundBitmap=Bitmap.createScaledBitmap(backgroundBitmap, displayX, displayY, true);
      }
      public void run(){
    	super.run();    
    	threadFlag=true;
    	while(threadFlag){
    		 canvas = view.surfaceHolder.lockCanvas();
    		try{ synchronized (view.surfaceHolder){
    	    	  updateDisplay();}
    	}catch(Exception e){
    		e.printStackTrace();}
    		finally{ if(canvas!=null)
    		{view.surfaceHolder.unlockCanvasAndPost(canvas);}
    		}
    	}
    	try{
    		Thread.sleep(17);}
    	catch(InterruptedException e){
    		e.printStackTrace();
    	}
      }
      public void stopThread(){
    	  threadFlag=false;
      }
      
    

	private void updateDisplay() {
		// TODO Auto-generated method stub
		canvas.drawBitmap(backgroundBitmap, 0, 0, null);
	}
      
      }
      
      

