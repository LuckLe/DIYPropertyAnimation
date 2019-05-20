package animation.hml.com.diypropertyanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import animation.hml.com.library.PathPoint;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private ImageView imgv;
    private Button btnLineAnimator;
    private Button btnBack;
    private Button btnBezierAnimator;
    private float x;
    private float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgv = findViewById(R.id.imgv);
        btnLineAnimator = findViewById(R.id.btn_line_animator);
        btnBack = findViewById(R.id.btn_back);
        btnBezierAnimator = findViewById(R.id.btn_bezier_animator);

        imgv.setOnClickListener(this);
        btnLineAnimator.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnBezierAnimator.setOnClickListener(this);

        btnLineAnimator.postDelayed(new Runnable() {
            @Override
            public void run() {
                x = imgv.getX();
                y = imgv.getY();
            }
        },200);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_line_animator:
                startLineAnimator();
                break;
            case R.id.imgv:
                Log.d(TAG,v.getX()+","+v.getY());
                break;
            case R.id.btn_back:
                imgv.setX(x);
                imgv.setY(y);
                break;
            case R.id.btn_bezier_animator:
                startBezierAnimator();
                break;
        }
    }

    private void startBezierAnimator() {
        PathPoint pathPoint = new PathPoint(PathPoint.Operation.CUBIC,imgv.getX(),imgv.getY());
        pathPoint.view = imgv;
        pathPoint.mEndPoint = new PathPoint(pathPoint.mX+800,pathPoint.mY);
        pathPoint.mControl0X = (int) (pathPoint.mX+200);
        pathPoint.mControl0Y = (int) (pathPoint.mY-300);
        pathPoint.mControl1X = (int) (pathPoint.mX+600);
        pathPoint.mControl1Y = (int) (pathPoint.mY+300);
        pathPoint.start();
    }

    private void startLineAnimator() {
        PathPoint pathPoint = new PathPoint(PathPoint.Operation.LINE,imgv.getX(),imgv.getY());
        pathPoint.view = imgv;
        pathPoint.mEndPoint = new PathPoint(pathPoint.mX+300,pathPoint.mY+500);
        pathPoint.start();
    }
}
