
package blecture5;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class BLecture5 {
    private JTextField tf = null; 
    private JTextArea ta = null;
    
public BLecture5(){
    
    JFrame jf = new JFrame("Button Test");
    
    //ステータスバー
    JPanel addressBar = new JPanel();
    
    tf = new JTextField("ファイル名を入れてください");
    ta = new JTextArea("本文用テキストエリア");

    JButton btn = new JButton("Load");
    JButton btn1 = new JButton("Save");
    
    jf.setLayout(new BorderLayout());
    jf.add(addressBar, BorderLayout.NORTH);
    jf.add(new JScrollPane(ta), BorderLayout.CENTER);
    jf.add(btn1, BorderLayout.SOUTH);
    
    addressBar.setLayout(new BorderLayout());
    addressBar.add(btn, BorderLayout.EAST);
    addressBar.add(tf, BorderLayout.CENTER);

    btn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {
            ta.append(tf.getText()+"\n");
            String fname = tf.getText();
            
        FileReader fr;

            try {
            // 入力用のファイルリーダを生成
            fr = new FileReader(fname);
            } catch (FileNotFoundException e) {
            System.out.println(fname + "がオープンできません。");
            return;
            }
            BufferedReader br = new BufferedReader(fr);
            String line;
            try {
            while ((line = br.readLine()) != null) {
                ta.append(line+"\n");
            }

            br.close();
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    });
    
    btn1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent a){
        String fname = tf.getText();
          
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fname));
            String str = ta.getText();
            String[] strs = str.split("¥n");
                for (int i = 0 ; i < strs.length ; i++){
                    pw.println(strs[i]);
                }
            pw.close();
            } catch (IOException e) {
            e.printStackTrace(); }         
        }
    });
    
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(320, 240);
        jf.setVisible(true);
        }

    public static void main(String[] args) {
        new BLecture5();
    }
    
}
