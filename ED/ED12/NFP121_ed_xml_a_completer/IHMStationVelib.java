
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;

public class IHMStationVelib extends JFrame {

  private JTextArea resultat = new JTextArea("", 20,60);
  private JButton info = new JButton("info");
  private JButton liste = new JButton("liste");
  private JTextField latitude = new JTextField("48.8671665");
  private JTextField longitude = new JTextField("2.3523933");  
  private JTextField station = new JTextField(4);
  private JTextField expr = new JTextField("TURBIG*");
  private DecimalFormat df; 

  private StationsVelibFacadeI facade;
  private Collection<StationVelib> lesStations;


  public IHMStationVelib() {
    this.setTitle("IHM StationVelib");
    Container container = this.getContentPane();
    station.setText("3011");
    container.setLayout(new BorderLayout());
    JScrollPane scrolltxt = new JScrollPane(resultat);
    scrolltxt.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    container.add(scrolltxt, BorderLayout.NORTH);
    JPanel p = new JPanel(new FlowLayout());
    p.add(new JLabel("ici lat:"));
    p.add(latitude);
    p.add(new JLabel(" lng:"));
    p.add(longitude);
    p.add(new JLabel(" la station: "));
    p.add(station);
    p.add(info);
    p.add(new JLabel(" une expression régulière: "));
    p.add(expr);
    p.add(liste);
    container.add(p, BorderLayout.SOUTH);

    this.df = new DecimalFormat();
    this.df.setMaximumFractionDigits(2);

    InputStream in = null;
    try{
      in = this.getClass().getResourceAsStream("stations.xml");
      this.facade = new StationsVelibFacadeImpl(in);
      this.lesStations = facade.getListeDesStations();
    }catch(Exception e){
    }
    info.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try{
            int numero = Integer.parseInt(station.getText());
            StationVelib station = facade.getStation(numero);
            String str = new String();
            str += station.getName() + "\n";
            if(station.getOpen()){
              InfoStation i = facade.getInfoStation(station);
              str += "\t" + i.getAvailable() + " vélos disponibles" + "\n" +
              "\t" + i.getFree() + " points d'attache disponibles " + "\n";
            }else{
              str += "\tstation fermée...\n";
            }
            double lat = Double.parseDouble(latitude.getText());
            double lng = Double.parseDouble(longitude.getText());
            double distance = facade.getDistance(lat,lng, station);
            str += "\tdistance vol d'oiseau: " + df.format(distance) + " km"; 

            resultat.setText(str);
          }catch(Exception e){
            resultat.setText("Exception ..., saisie incorrecte ");
          }
        }
      });
    liste.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          try{
            Pattern pattern = Pattern.compile(expr.getText());
            String str = new String();
            for( StationVelib s : lesStations){
              Matcher m = pattern.matcher(s.getFullAddress());
              if(m.find()){  
                str += s.getName() + ", " + s.getFullAddress() + "\n";
              }
            }
            resultat.setText(str);
            pack();
          }catch(Exception e){
            resultat.setText("Exception .. " + e.getMessage());
          }finally{
            if(expr.getText().length()==0)expr.setText("TURBIG*");
          }
        }
      });

    //     this.visiter.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent ae) {
    //           Element racine = g.accepter(new VisiteurToXML());
    //           XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
    //           Document document = new Document(racine);
    //           ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //           try{
    //             out.output(document, baos);
    //           }catch(Exception e){
    //             e.printStackTrace();
    //           }
    //           resultat.setText(baos.toString());
    //           try{
    //             baos.close();
    //           }catch(Exception e){
    //           }
    //           pack();
    //         }            
    //       });

    this.pack();
    this.setVisible(true);
  }

  public static void main() {
    new IHMStationVelib();    
  }    

}