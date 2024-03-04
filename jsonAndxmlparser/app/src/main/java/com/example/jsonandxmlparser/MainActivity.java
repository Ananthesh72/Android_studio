package com.example.jsonandxmlparser;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class MainActivity extends AppCompatActivity {
    Button b_xml, b_json;
    TextView displayX,displayJ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_xml = findViewById(R.id.btnXml);
        b_json = findViewById(R.id.btnJson);
        displayX = findViewById(R.id.txtXml);
        displayJ = findViewById(R.id.txtJson);
        b_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is=getAssets().open("a.xml");
                    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
                    DocumentBuilder db= dbf.newDocumentBuilder();
                    Document d=db.parse(is);
                    StringBuilder s= new StringBuilder();
                    s.append("XML data");
                    s.append("\n--------------");
                    NodeList nodeList=d.getElementsByTagName("location");
                    for(int i=0;i<nodeList.getLength();i++)
                    {
                        Node node= nodeList.item(i);
                        if(node.getNodeType()==Node.ELEMENT_NODE)
                        {
                            Element element =(Element)node;
                            s.append("place").append(getValue("place"));
                            s.append("latitude").append(getValue("latitude"));
                            s.append("longitude").append(getValue("longitude"));
                            s.append("temperature").append(getValue("temperature"));
                            s.append("humidity").append(getValue("humidity"));
                        }
                    }
                    displayX.setText(s.toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"error in parsing",Toast.LENGTH_SHORT).show();
                }
            }
        });
        b_json.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String json;
                                          StringBuilder jsontxt = new StringBuilder();
                                          String str=null;
                                          try {
                                              InputStream is = getAssets().open("a.json");
                                              int size = is.available();
                                              byte[] buffer = new byte[size];
                                              is.read(buffer);
                                              json = new String(buffer, StandardCharsets.UTF_8);
                                              JSONArray jsonArray = new JSONArray(json);
                                              jsontxt.append("JSON DATA");
                                              jsontxt.append("\n----------------------");
                                              for (int i = 0; i < jsonArray.length(); i++) {
                                                  JSONObject jsonObject = jsonArray.getJSONObject(i);
                                                  jsontxt.append("\nPlace: ").append(jsonObject.getString("place"));
                                                  jsontxt.append("\nLatitude: ").append(jsonObject.getString("latitude"));
                                                  jsontxt.append("\nLongitude: ").append(jsonObject.getString("longitude"));
                                                  jsontxt.append("\nTemperature:").append(jsonObject.getString("temperature"));
                                                  jsontxt.append("\nHumidity:").append(jsonObject.getString("humidity"));
                                                  jsontxt.append("\n------------------------");
                                              }
                                              displayJ.setText(jsontxt.toString());
                                              is.close();
                                          }
                                          catch (Exception e){
                                              e.printStackTrace();
                                              Toast.makeText(MainActivity.this,"Error in reading",Toast.LENGTH_LONG).show();
                                          }
                                      }
                                  }
        );
    }
    private String getValue (String tag){
        Document element=null;
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}