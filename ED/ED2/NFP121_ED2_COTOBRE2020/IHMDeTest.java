import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IHMDeTest extends JFrame{

  // Modele
  private Entier e;
  
  // Interface Humain Machine 
  private JButton    enter;
  private JTextField data,console;
  
  public IHMDeTest(){
    super("IHMDeTest");
    this.e = new Entier(1);
      
    JRootPane rootPane = this.getRootPane();  
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
 
    this.console = new JTextField(e.toString());
    Font bigFont = console.getFont().deriveFont(Font.PLAIN, 150f);
    this.console.setFont(bigFont);
    this.console.setHorizontalAlignment(JTextField.CENTER);
    panel.add(console, BorderLayout.CENTER);
    
    JPanel dialog = new JPanel();
    
    this.data = new JTextField("1",10);
    this.data.setHorizontalAlignment(JTextField.RIGHT);
    dialog.add(data);
    this.enter = new JButton("enter");
    this.enter.addActionListener( new Enter());
    dialog.add(enter);
    
    panel.add(dialog, BorderLayout.PAGE_END);
    
    add(panel); //rootPane.setContentPane(panel);
    pack();
    setVisible(true);
  }
  
  private class Enter implements ActionListener{
    public void actionPerformed(ActionEvent ae){
        try {
            e = Entier.parseEntier(data.getText());
            String hexa = e.toString(16).toUpperCase();
            console.setText(hexa);
        } catch (NumberFormatException e) {
            console.setText("?");
        }
    }
  }
  
  public static void main(String[] args){
    new IHMDeTest();
  }
  
}