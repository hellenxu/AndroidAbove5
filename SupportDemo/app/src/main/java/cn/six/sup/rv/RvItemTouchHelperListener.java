package cn.six.sup.rv;

/**
 * Created by songzhw on 2016-06-09.
 */
public interface RvItemTouchHelperListener {
    void onMove(int fromPosition, int toPosition);
    void onSwiped(int position);
    void onFinishDrag();
}
