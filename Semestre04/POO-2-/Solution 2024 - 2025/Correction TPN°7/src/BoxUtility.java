public class BoxUtility <T>{
    public  void swapBoxContents(Box <T> box1, Box <T> box2){
        T tmp_swap = box1.getContent();
     box1.setContent(box2.getContent());
     box2.setContent(tmp_swap);
    }
}
