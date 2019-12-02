import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class listDir {
    private static ArrayList<File> fileArrayList = new ArrayList<>();
    private listDir(File dir){
        File[] files = dir.listFiles();
        assert files != null;
        for (File file:files) {
            if(file.isDirectory()){
                new listDir(file);
            }else {
                fileArrayList.add(file);
            }
        }
    }

    public static void main(String[] args) {
        new listDir(new File("D:\\拍摄\\照片处理后"));
        for(File file:fileArrayList){
//            fileArrayList.sort(file,new Comparable<>(){
//
//                @Override
//                public int compareTo(Object o) {
//                    return 0;
//                }
//            });
            System.out.println(file+" "+file.length());
        }
    }

}
