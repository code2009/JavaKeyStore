public class JavaCmdKeyStore {
    
    
    public static List<String> filePathList= new ArrayList();
    public static void main(String arg[]) {
    
       File mFile = new File("F:/APK_Folder" );
        showApkFiles(mFile );
    }

    private static void doExec(String apkPath,String name ) {
        try{
           Process p= null;
           Runtime r=Runtime. getRuntime();
           System. out.println("start:" + "Ö´ÐÐ" );
           String run= "java -jar F:/APK_Folder/SignApk.jar F:/APK_Folder/platform.x509.pem F:/APK_Folder/platform.pk8"
                  + " " + apkPath + " "   + "E:/APK_Folder/" + name ;
           System. out.println(run );
            p= r.exec( run);
       } catch(Exception e ){
           System. out.println("error:" +e .getMessage());
            e.printStackTrace();
       }
    }

    private static void showApkFiles(File mFile) {
       File[] m = mFile.listFiles();
        for(File tmp : m ) {
            if(tmp .getAbsolutePath().endsWith(".apk")) {
                filePathList.add(tmp .getName());
                doExec(tmp.getAbsolutePath(), tmp.getName());
                try {
                  Thread. sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }
}
