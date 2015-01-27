/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static project1.Language.Languages;

/**
 *
 * @author karthik reddy
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private ComboBox<String> lhsComboBox;
    @FXML
    private TextArea lhsTextArea;
    @FXML
    private Button lhsSubmitButton;
    @FXML
    private Button lhsWhatButton;
    @FXML
    private ComboBox<String> rhsComboBox;
    @FXML
    private TextArea rhsTextArea;
    @FXML
    private Button rhsSubmitButtton;
    @FXML
    private Button rhsWhatButton;
    
    
    @FXML
    private Label lhsWhatCounterLabel;
    @FXML
    private Label rhsWhatCounterLabel;
    @FXML
    private Label lhsCommonQs;
    @FXML
    private Button lhsFaq1;
    @FXML
    private Button lhsFaq2;
    @FXML
    private Button lhsFaq3;
    @FXML
    private Button lhsFaq4;
    @FXML
    private Button lhsFaq5;
    @FXML
    private Button lhsFaq6;
    @FXML
    private Label rhsCommonQs;
    @FXML
    private Button rhsFaq3;
    @FXML
    private Button rhsFaq5;
    @FXML
    private Button rhsFaq1;
    @FXML
    private Button rhsFaq6;
    @FXML
    private Button rhsFaq2;
    @FXML
    private Button rhsFaq4;
    
    @FXML
    private Button lhsDoneButton;
    @FXML
    private Button rhsDoneButton;
    
    @FXML
    private Label lhsFinLabel;
    @FXML
    private Label rhsFinLabel;
    @FXML
    private Label lhsSubmitLabel;
    @FXML
    private Label rhsSubmitLabel;
    @FXML
    private Label lhsChooseLanguage;
    @FXML
    private Label rhsChooseLanguage;
    
    
    public final String SUBMIT="Send";
    public final String FREQUENT_TOPICS="Frequent topics";
    public final String CANT_UNDERSTAND="Can't understand";
    public final String CLOSE="Close";
    public final String CHOOSE_LANGUAGE="Choose your language";
    public final String TEXT_AREA_PROMPT="Enter text here";
    
    public final String DIRECTION="Direction";
    public final String FOOD="Food";
    public final String WEATHER="Weather";
    public final String MONEY="Money";
    public final String TIME="Time";
    public final String TRANSPORT="Transport";
    
    
    
    
    
    public static HashMap<String,String> languagesHashMap=new HashMap<>();
    public TranslateService ts=new TranslateService();
    String newKey;
    String text;
    String target;
    String source;
    String translatedText;
    int lhsWhatCounter=0;
    int rhsWhatCounter=0;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      populateHashMap();          
      
      lhsChooseLanguage.setText(CHOOSE_LANGUAGE);
      rhsChooseLanguage.setText(CHOOSE_LANGUAGE);
      
      lhsTextArea.setPromptText(TEXT_AREA_PROMPT);
      rhsTextArea.setPromptText(TEXT_AREA_PROMPT);
      
      Set<String> langs= languagesHashMap.keySet();
      ObservableList<String> languageOptions = FXCollections.observableArrayList(langs);
      lhsComboBox.setItems(languageOptions);
      rhsComboBox.setItems(languageOptions);
      
     // lhsComboBox.setValue("English");
      
        ImageView imageView1 = new ImageView(new Image(getClass().getResourceAsStream("garrow.jpg")));

        imageView1.fitWidthProperty().bind(lhsSubmitButton.widthProperty());
        imageView1.fitHeightProperty().bind(lhsSubmitButton.heightProperty());
        ImageView imageView2 = new ImageView(new Image(getClass().getResourceAsStream(("garrow - Copy.jpg"))));
        imageView2.fitWidthProperty().bind(rhsSubmitButtton.widthProperty());
        imageView2.fitHeightProperty().bind(rhsSubmitButtton.heightProperty());
        
        lhsSubmitButton.setGraphic(imageView1);
        rhsSubmitButtton.setGraphic(imageView2);
      
      
      ImageView confusedImage1 = new ImageView(new Image(getClass().getResourceAsStream(("confused.png"))));
      confusedImage1.fitWidthProperty().bind(lhsWhatButton.widthProperty());
        confusedImage1.fitHeightProperty().bind(lhsWhatButton.heightProperty());

        confusedImage1.fitHeightProperty().bind(lhsWhatButton.heightProperty());
      ImageView confusedImage2 = new ImageView(new Image(getClass().getResourceAsStream(("confused.png"))));
      confusedImage2.fitWidthProperty().bind(rhsWhatButton.widthProperty());
        confusedImage2.fitHeightProperty().bind(rhsWhatButton.heightProperty());
      lhsWhatButton.setGraphic(confusedImage1);
      rhsWhatButton.setGraphic(confusedImage2);
    
    
    
    ImageView directionImg1 = new ImageView(new Image(getClass().getResourceAsStream(("directions.gif"))));
    ImageView directionImg2 = new ImageView(new Image(getClass().getResourceAsStream(("directions.gif"))));
    directionImg1.fitWidthProperty().bind(lhsFaq1.widthProperty());
    directionImg1.fitHeightProperty().bind(lhsFaq1.heightProperty());
    directionImg2.fitWidthProperty().bind(rhsFaq1.widthProperty());
    directionImg2.fitHeightProperty().bind(rhsFaq1.heightProperty());
    lhsFaq1.setGraphic(directionImg1);
    rhsFaq1.setGraphic(directionImg2);
        
    ImageView foodImg1 = new ImageView(new Image(getClass().getResourceAsStream(("fastfood.gif"))));
    ImageView foodImg2 = new ImageView(new Image(getClass().getResourceAsStream(("fastfood.gif"))));
    foodImg1.fitWidthProperty().bind(lhsFaq2.widthProperty());
    foodImg1.fitHeightProperty().bind(lhsFaq2.heightProperty());
    foodImg2.fitWidthProperty().bind(rhsFaq2.widthProperty());
    foodImg2.fitHeightProperty().bind(rhsFaq2.widthProperty());
    lhsFaq2.setGraphic(foodImg1);
    rhsFaq2.setGraphic(foodImg2);
    
    ImageView weatherImg1 = new ImageView(new Image(getClass().getResourceAsStream(("weather.jpg"))));
    ImageView weatherImg2 = new ImageView(new Image(getClass().getResourceAsStream(("weather.jpg"))));
    weatherImg1.fitWidthProperty().bind(lhsFaq3.widthProperty());
    weatherImg1.fitHeightProperty().bind(rhsFaq3.heightProperty());
    weatherImg2.fitWidthProperty().bind(lhsFaq3.widthProperty());
    weatherImg2.fitHeightProperty().bind(rhsFaq3.widthProperty());
    lhsFaq3.setGraphic(weatherImg1);
    rhsFaq3.setGraphic(weatherImg2);
    
    ImageView timeImg1 = new ImageView(new Image(getClass().getResourceAsStream(("time.jpg"))));
    ImageView timeImg2 = new ImageView(new Image(getClass().getResourceAsStream(("time.jpg"))));
    timeImg1.fitWidthProperty().bind(lhsFaq4.widthProperty());
    timeImg1.fitHeightProperty().bind(rhsFaq4.heightProperty());
    timeImg2.fitWidthProperty().bind(lhsFaq4.widthProperty());
    timeImg2.fitHeightProperty().bind(rhsFaq4.widthProperty());
    lhsFaq4.setGraphic(timeImg1);
    rhsFaq4.setGraphic(timeImg2);
    
    ImageView transportImg1 = new ImageView(new Image(getClass().getResourceAsStream(("transport.jpg"))));
    ImageView transportImg2 = new ImageView(new Image(getClass().getResourceAsStream(("transport.jpg"))));
    transportImg1.fitWidthProperty().bind(lhsFaq5.widthProperty());
    transportImg1.fitHeightProperty().bind(rhsFaq5.heightProperty());
    transportImg2.fitWidthProperty().bind(lhsFaq5.widthProperty());
    transportImg2.fitHeightProperty().bind(rhsFaq5.widthProperty());
    lhsFaq5.setGraphic(transportImg1);
    rhsFaq5.setGraphic(transportImg2);
   
    
    ImageView moneyImg1 = new ImageView(new Image(getClass().getResourceAsStream(("currency-world.jpg"))));
    ImageView moneyImg2 = new ImageView(new Image(getClass().getResourceAsStream(("currency-world.jpg"))));
    moneyImg1.fitWidthProperty().bind(lhsFaq6.widthProperty());
    moneyImg1.fitHeightProperty().bind(rhsFaq6.heightProperty());
    moneyImg2.fitWidthProperty().bind(lhsFaq6.widthProperty());
    moneyImg2.fitHeightProperty().bind(rhsFaq6.widthProperty());
    lhsFaq6.setGraphic(moneyImg1);
    rhsFaq6.setGraphic(moneyImg2);
    
    
     ImageView finishedImg1 = new ImageView(new Image(getClass().getResourceAsStream("fin.jpg")));
        finishedImg1.fitWidthProperty().bind(lhsDoneButton.widthProperty());
        finishedImg1.fitHeightProperty().bind(lhsDoneButton.heightProperty());
        lhsDoneButton.setGraphic(finishedImg1);
        ImageView finishedImg2 = new ImageView(new Image(getClass().getResourceAsStream(("fin.jpg"))));
        finishedImg2.fitWidthProperty().bind(rhsDoneButton.widthProperty());
        finishedImg2.fitHeightProperty().bind(rhsDoneButton.heightProperty());
    rhsDoneButton.setGraphic(finishedImg2);
    }    

    @FXML
    private void lhsComboBoxSelected(ActionEvent event) throws IOException {
    try{
    lhsCommonQs.setText(ts.translate(FREQUENT_TOPICS, languagesHashMap.get(lhsComboBox.getValue()), Language.English));
    lhsFinLabel.setText(ts.translate(CLOSE, languagesHashMap.get(lhsComboBox.getValue()), Language.English));
    lhsWhatCounterLabel.setText(ts.translate(CANT_UNDERSTAND, languagesHashMap.get(lhsComboBox.getValue()), Language.English));
    lhsSubmitLabel.setText(ts.translate(SUBMIT, languagesHashMap.get(lhsComboBox.getValue()), Language.English));
    }catch(Exception e){
    lhsCommonQs.setText(FREQUENT_TOPICS);
    lhsFinLabel.setText(CLOSE);
    lhsWhatCounterLabel.setText(CANT_UNDERSTAND);
    lhsSubmitLabel.setText(SUBMIT);
    }
        
        
    lhsWhatCounter=0;
        
    }

    @FXML
    private void lhsSubmitButtonPressed(ActionEvent event) throws IOException {
                        text=lhsTextArea.getText();
        target=languagesHashMap.get(rhsComboBox.getValue());
        source=languagesHashMap.get(lhsComboBox.getValue());
     try{         
        translatedText=ts.translate(text, target, source);
        
        rhsTextArea.setText(translatedText);
        
            }catch(Exception e){
                rhsTextArea.setText(text);
    }
  
    }

    @FXML
    private void rhsWhatButtonPressed(ActionEvent event) {
        rhsWhatCounter++;
        rhsWhatCounterLabel.setText(""+rhsWhatCounter);
    }
    
    
    @FXML
    private void lhsWhatButtonPressed(ActionEvent event) {

        lhsWhatCounter++;
        lhsWhatCounterLabel.setText(""+lhsWhatCounter);
    }
    

    @FXML
    private void rhsComboBoxSelected(ActionEvent event) throws IOException {
    try{
    rhsCommonQs.setText(ts.translate(FREQUENT_TOPICS, languagesHashMap.get(rhsComboBox.getValue()), Language.English));
    rhsFinLabel.setText(ts.translate(CLOSE, languagesHashMap.get(rhsComboBox.getValue()), Language.English));
    rhsWhatCounterLabel.setText(ts.translate(CANT_UNDERSTAND, languagesHashMap.get(rhsComboBox.getValue()), Language.English));
    rhsSubmitLabel.setText(ts.translate(SUBMIT, languagesHashMap.get(rhsComboBox.getValue()), Language.English));
    }catch(Exception e){
    rhsCommonQs.setText(FREQUENT_TOPICS);
    rhsFinLabel.setText(CLOSE);
    rhsWhatCounterLabel.setText(CANT_UNDERSTAND);
    rhsSubmitLabel.setText(SUBMIT);
    }
        
        
    rhsWhatCounter=0;
        
    }

    @FXML
    private void rhsSubmitButtonPressed(ActionEvent event) throws IOException {
    text=rhsTextArea.getText();
        target=languagesHashMap.get(lhsComboBox.getValue());
        source=languagesHashMap.get(rhsComboBox.getValue());
     try{
        translatedText=ts.translate(text, target, source);
    
    lhsTextArea.setText(translatedText);
          }catch(Exception e){
              lhsTextArea.setText(text);
    }
    }

    private void populateHashMap() {
        languagesHashMap.put("English", "en");
        for (String key:Languages.keySet()){
        try{
        
        newKey=ts.translate(key, Languages.get(key), Language.English);
        languagesHashMap.put(newKey, Languages.get(key));
    
        }
        catch(Exception e){
            System.out.println(key);
        }
        }
        languagesHashMap.remove("ChineseSimplified");
        languagesHashMap.remove("ChineseTraditional");
        languagesHashMap.put("中国",Language.ChineseSimplified);
        languagesHashMap.put("中國",Language.ChineseTraditional);
    }

    @FXML
    private void directionPressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
        try{
            lhsTextArea.setText(ts.translate(DIRECTION,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(DIRECTION);
    }
        
        }
        if(rhsComboBox.getValue()!=null){
        try{
            rhsTextArea.setText(ts.translate(DIRECTION,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(DIRECTION);
    }
        }
        
        
    }

    @FXML
    private void foodPressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
        try{
            lhsTextArea.setText(ts.translate(FOOD,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(FOOD);
    }
        
        }
        if(rhsComboBox.getValue()!=null){
try{        rhsTextArea.setText(ts.translate(FOOD,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(FOOD);
    }
        }
    
    }

    @FXML
    private void weatherPressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
        try{lhsTextArea.setText(ts.translate(WEATHER,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(WEATHER);
    }
        if(rhsComboBox.getValue()!=null){
        try{rhsTextArea.setText(ts.translate(WEATHER,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(WEATHER);
    }
        }
    }}

    @FXML
    private void timePressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
        try{lhsTextArea.setText(ts.translate(TIME,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(TIME);
    }
        if(rhsComboBox.getValue()!=null){
        try{rhsTextArea.setText(ts.translate(TIME,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(TIME);
    }
        }
        }
    }

    @FXML
    private void transportPressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
      try{  lhsTextArea.setText(ts.translate(TRANSPORT,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(TRANSPORT);
    }
        if(rhsComboBox.getValue()!=null){
        try{rhsTextArea.setText(ts.translate(TRANSPORT,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(TRANSPORT);
    }
        }
    }
    }
    
    @FXML
    private void moneyPressed(ActionEvent event) throws IOException {
        if(lhsComboBox.getValue()!=null){
        try{lhsTextArea.setText(ts.translate(MONEY,languagesHashMap.get(lhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              lhsTextArea.setText(MONEY);
    }
        if(rhsComboBox.getValue()!=null){
        try{
        rhsTextArea.setText(ts.translate(MONEY,languagesHashMap.get(rhsComboBox.getValue()),Language.English));
        }catch(Exception e){
              rhsTextArea.setText(MONEY);
    }
    
    }



        }}

    @FXML
    private void doneButtonPressed(ActionEvent event) {
 
           try {
   //Set your page url in this string.
         String url = "https://ufl.qualtrics.com/SE/?SID=SV_0v4PncAgobS8DZz";
         java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
       }
       catch (java.io.IOException e) {
//           System.out.println(e.getMessage());

    
    }
}}