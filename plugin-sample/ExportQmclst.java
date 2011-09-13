package plugin;
import java.io.*;

import viewer.viewConfigPanel.plugin.ExportPluginInterface;

public class ExportQmclst implements ExportPluginInterface {
  public String getName(){
    return "qmclst Format";
  }
  public void exec(String dir, int fn,
                   float[][] h,
                   float[][] hinv,
                   int n,
                   float[][] r,
                   byte[] tag,
                   int[] vtag
                   ){

    String filePath=String.format(dir+"/%04d.qmclst00",fn);
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    String str;

    // open
    try{
      fw = new FileWriter( filePath );
      bw = new BufferedWriter( fw );
      pw = new PrintWriter( bw );



      int nv=0;
      double[] xt={0.,0.,0.};
      for(int i=0;i<n;i++){
        if(vtag[i]<0)continue;
        nv++;
        for(int k=0; k<3; k++)xt[k] += hinv[k][0]*r[i][0]+hinv[k][1]*r[i][1]+hinv[k][2]*r[i][2];
      }
      for(int k=0; k<3; k++)xt[k]/=nv;

      System.out.println(String.format("output Natom: %d",nv));

      pw.println(String.format("%e %e %e",xt[0],xt[1],xt[2]));//xtarget
      pw.println(String.format("%d",n));

      for(int i=0;i<n;i++){
        //int itag=atoms.tag[i]-1;
        //if(!ctrl.vconf.tagOnOff[itag])continue;
        if(vtag[i]<0)continue;

        float[] out = new float[3];
        for(int k=0; k<3; k++)
          out[k] = hinv[k][0]*r[i][0]+hinv[k][1]*r[i][1]+hinv[k][2]*r[i][2];

        pw.println(String.format("%e %e %e",out[0],out[1],out[2]));
      }

      pw.close();
      bw.close();
      fw.close();
    }catch( IOException e ){
      System.out.println("---> Failed to write qmclst file");
      //System.out.println(e.getMessage());
    }

  }
}
