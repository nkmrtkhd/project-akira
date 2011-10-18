package viewer.viewConfigPanel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import info.clearthought.layout.*;
import java.util.*;
import java.io.*;

import viewer.*;
import tools.*;
import viewer.renderer.*;

public class StatusPanel extends JPanel implements ActionListener,ChangeListener{

  /* accesser starts*/

  public void updateStatusString(RenderingWindow rw){
    lNatm.setText(String.format("# of atoms: %d/%d",rw.getVisibleNAtoms()
                                ,rw.getNAtoms()));
    lBox1.setText(String.format("%7.1f %7.1f %7.1f",rw.atoms.h[0][0],rw.atoms.h[0][1],rw.atoms.h[0][2]));
    lBox2.setText(String.format("%7.1f %7.1f %7.1f",rw.atoms.h[1][0],rw.atoms.h[1][1],rw.atoms.h[1][2]));
    lBox3.setText(String.format("%7.1f %7.1f %7.1f",rw.atoms.h[2][0],rw.atoms.h[2][1],rw.atoms.h[2][2]));

    lFrame.setText(String.format("Frame No.: %d/%d",rw.currentFrame+1,rw.atoms.totalFrame));
    slFrame.setMaximum(rw.atoms.totalFrame-1);
    if(!rw.isAnimating())slFrame.setValue(rw.currentFrame);
    lFPS.setText(String.format("Frame per Second: %d",rw.fps));
    slFPS.setValue(rw.fps);
    slFPS.setMinimum(rw.fpsMin);
    slFPS.setMaximum(rw.fpsMax);



  }
  /* accesser ends*/

  public void actionPerformed( ActionEvent ae){
    if( ae.getSource() == popoutButton ){
      vconf.isPopStatus=!vconf.isPopStatus;
      updateStatusFrame();
    }

  }

  // called when the event happens
  public void stateChanged(ChangeEvent ce){
    if( ce.getSource() == slFPS ){
      ctrl.setFPS(slFPS.getValue());
    }else if( ce.getSource() == slFrame ){
      ctrl.setFrame(slFrame.getValue());
    }
  }




  private Controller ctrl;
  private ViewConfig vconf;
  //constructor
  public StatusPanel(Controller ctrl){
    this.ctrl=ctrl;
    this.vconf=ctrl.vconf;
    create();

    updateStatusFrame();
  }

  //global variables
  private JLabel lNatm,lBox1,lBox2,lBox3;
  private JLabel lFPS,lFrame;
  private JSlider slFrame,slFPS;
  private JButton popoutButton;



  private JPanel sPanel;
  private JScrollPane stdOutErrPane;
  private JLabel stdOutErrLabel=new JLabel("STDOUT, STDERR is popouted");
  public JFrame statusFrame=new JFrame("Status Frame");

  public void create(){

    statusFrame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          vconf.isPopStatus=false;
          updateStatusFrame();
        }
      });

    //General panel
    setFocusable( false );

    //-----left: num. of atoms, box matrix
    lNatm= new JLabel("Num. of atoms: ");
    lNatm.setFocusable(false);
    JLabel lBoxMat= new JLabel("Box matrix:");
    lBoxMat.setFocusable(false);
    lBox1=new JLabel("");
    lBox1.setFocusable(false);
    lBox2=new JLabel("");
    lBox2.setFocusable(false);
    lBox3=new JLabel("");
    lBox3.setFocusable(false);



    //-----center: frame No.
    lFrame= new JLabel("Frame No.: ");
    lFrame.setFocusable(false);
    slFrame = new JSlider();
    slFrame.setFocusable(false);
    slFrame.addChangeListener(this);
    slFrame.setMajorTickSpacing(1);
    slFrame.setPaintTicks(true);
    slFrame.setSnapToTicks(true);
    slFrame.setValue(0);
    slFrame.setMinimum(0);
    slFrame.setMaximum(10);

    lFPS= new JLabel("FPS: ");
    lFPS.setFocusable(false);
    slFPS = new JSlider();
    slFPS.setFocusable(false);
    slFPS.addChangeListener(this);
    slFPS.setValue(0);
    slFPS.setMinimum(0);
    slFPS.setMaximum(10);
    slFPS.setMajorTickSpacing(5);
    slFPS.setMinorTickSpacing(1);
    slFPS.setPaintTicks(true);
    slFPS.setSnapToTicks(true);

    popoutButton = new JButton( "Popout Status Panel" );
    popoutButton.addActionListener( this );
    popoutButton.setFocusable(false);


    //-----left column: num of atoms, box matrix
    JPanel leftPanel= new JPanel();
    leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
    leftPanel.add(lNatm);
    leftPanel.add(lBoxMat);
    leftPanel.add(lBox1);
    leftPanel.add(lBox2);
    leftPanel.add(lBox3);
    //
    JPanel rightPanel= new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
    rightPanel.add(lFrame);
    rightPanel.add(slFrame);
    rightPanel.add(lFPS);
    rightPanel.add(slFPS);

    // outout area
    JTextArea outArea = new JTextArea();
    outArea.setEditable(false);
    outArea.setLineWrap(true);
    outArea.setCaretPosition(outArea.getText().length());
    outArea.setFocusable(false);
    stdOutErrPane = new JScrollPane(outArea,
                                    ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    stdOutErrPane.setFocusable(false);
    sPanel= new JPanel();
    sPanel.setLayout(new GridLayout(1, 1));
    sPanel.add(stdOutErrPane);


    setLayout(new GridLayout(1, 1));
    //print streamを乗っ取る．かならずこの順で乗っ取る．
    System.setErr(new PrintStream(new JTextAreaOutputStream(System.out,outArea)));
    System.setOut(new PrintStream(new JTextAreaOutputStream(System.out,outArea)));

    leftPanel.setPreferredSize(new Dimension(200, 10));
    rightPanel.setPreferredSize(new Dimension(200, 10));

    //-----constants for TableLayout
    double f= TableLayout.FILL;
    double p= TableLayout.PREFERRED;
    double hb= 10;//10px?
    double colSizeTL[]= {hb,p,hb,p,hb,f,hb};
    double rowSizeTL[]= {hb,f,hb,p,hb};

    setLayout(new TableLayout(colSizeTL,rowSizeTL));

    this.add(leftPanel,    "1,1,1,3");
    this.add(rightPanel,   "3,1,f,f");
    this.add(popoutButton, "3,3,r,b");
    this.add(sPanel,"5,1,5,3");

  }

  public class JTextAreaOutputStream extends OutputStream {
    private JTextArea ta;
    private PrintStream system;
    public JTextAreaOutputStream(PrintStream p,JTextArea t){
      super();
      ta = t;
      system=p;
    }
    public void write(int i){
      char[] chars = new char[1];
      chars[0] = (char) i;
      String s = new String(chars);
      ta.append(s);
      system.write(i);
      ta.setCaretPosition(ta.getText().length());
    }
    public void write(char[] buf, int off, int len){
      String s = new String(buf, off, len);
      ta.append(s);
      ta.setCaretPosition(ta.getText().length());
      //ps.write(buf,off,len);
    }
  }

  void updateStatusFrame(){
    if(vconf.isPopStatus){
      //frame popout
      statusFrame.setBounds(vconf.rectStatusWin);
      sPanel.remove(stdOutErrPane);
      sPanel.add(stdOutErrLabel);
      statusFrame.add(stdOutErrPane);
      statusFrame.setVisible(true);
    }else{
      //set vcWin
      vconf.rectStatusWin = statusFrame.getBounds();
      statusFrame.setVisible(false);
      statusFrame.remove(stdOutErrPane);
      sPanel.remove(stdOutErrLabel);
      sPanel.add(stdOutErrPane);
    }
    this.repaint();
  }

}
