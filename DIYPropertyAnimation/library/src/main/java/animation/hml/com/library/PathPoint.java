package animation.hml.com.library;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;


/**
 * Created by hml on 2019/4/12.
 */
public class PathPoint implements ValueAnimator.AnimatorUpdateListener {

    private static final String TAG = "PathPoint";
    public Operation mOperation;
    public float mX;
    public float mY;
    public int mControl0X;//控制点1的x
    public int mControl0Y;//控制点1的y
    public int mControl1X;//控制点2的x
    public int mControl1Y;//控制点2的y
    public long mDuration = 1000;
    public PathPoint mEndPoint;//终点
    public View view;

    public PathPoint(Operation operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    public PathPoint(float x, float y) {
        mX = x;
        mY = y;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        PathPoint pathPoint = (PathPoint) animation.getAnimatedValue();
        Log.d(TAG,pathPoint.mX+","+pathPoint.mY);
        view.setX(pathPoint.mX);
        view.setY(pathPoint.mY);
    }

    public enum Operation{
        CUBIC,//贝塞尔曲线
        LINE,//直线运动
        MOVE,//运动
    }

    public void start(){
        if (view == null) {
            throw new NullPointerException("动画控件不能为空");
        }
        if (mEndPoint == null) {
            throw new NullPointerException("终点不能为空");
        }
        //贝塞尔曲线
        if (mOperation == Operation.CUBIC){
            if (mControl0X==0 && mControl0Y == 0){
                throw new NullPointerException("三阶贝塞尔曲线的第一个控制点不能为空");
            }
            if (mControl1X==0 && mControl1Y == 0){
                throw new NullPointerException("三阶贝塞尔曲线的第二个控制点不能为空");
            }
        }
        ValueAnimator animator = new ValueAnimator();
        animator.setObjectValues(this,mEndPoint);
        animator.setEvaluator(new PathEvaluator());
        animator.setDuration(mDuration);
        animator.start();
        animator.addUpdateListener(this);
    }

}
