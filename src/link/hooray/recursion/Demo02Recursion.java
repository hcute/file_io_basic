package link.hooray.recursion;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo02Recursion {

    public static void main(String[] args) {
//        System.out.println(sum(100));
//        System.out.println(factorial(4));
        // /Users/mac/Downloads/china_regions
//        printDir("/Users/mac/Downloads/china_regions");
//        findFileInDir("/Users/mac/Downloads/china_regions");
        findFileInDirByFilter("/Users/mac/Downloads/china_regions");
    }

    /**
     * 计算1到n的和
     */
    private static int sum(int n){
        if (n == 1) {
            return 1;
        }
        return n + sum(n-1);
    }

    private static int factorial(int n) {
        if (n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    /**
     * 文件遍历
     * @param path
     */
    private static void printDir(String path){
        File file = new File(path);
        if (file.exists()){
            File[] files = file.listFiles();

            for (File f1 : files) {
                if (f1.isDirectory()) {
                    printDir(f1.getAbsolutePath());
                }
                System.out.println(f1.getAbsolutePath() + File.separator + f1.getName());
            }
        }
    }

    /**
     * 文件的搜索
     * @param path
     */
    private static void findFileInDir(String path){
        File file = new File(path);
        if (file.exists()){
            File[] files = file.listFiles();
            for (File f1 : files) {
                if (f1.isDirectory()) {
                    findFileInDir(f1.getAbsolutePath());
                }else {
                    if (f1.getName().toLowerCase().endsWith(".json")) {
                        System.out.println(f1.getAbsolutePath() + File.separator + f1.getName());
                    }
                }
            }
        }
    }

    /**
     * 使用过滤器进行文件搜索
     * @param path
     */
    private static void findFileInDirByFilter(String path){
        File file = new File(path);
        if (file.exists()){
            File[] files = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".json");
                }
            });
            for (File f1 : files) {
                if (f1.isDirectory()) {
                    findFileInDir(f1.getAbsolutePath());
                }else {
                    if (f1.getName().toLowerCase().endsWith(".json")) {
                        System.out.println(f1.getAbsolutePath() + File.separator + f1.getName());
                    }
                }
            }
        }
    }

    private static class FileFilterImpl implements FileFilter{
        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".json")) {
                return true;
            }else {
                return false;
            }
        }
    }
}
