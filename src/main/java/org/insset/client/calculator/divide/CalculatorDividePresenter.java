package org.insset.client.calculator.divide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.DivideService;
import org.insset.client.service.DivideServiceAsync;
import org.insset.shared.FieldVerifier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author talend
 */
public class CalculatorDividePresenter extends Composite {

    @UiField
    public ResetButton boutonClear;
    @UiField
    public SubmitButton boutonDivide;
    @UiField
    public TextBox valDividende;
    @UiField
    public TextBox valDiviseur;
    @UiField
    public Label errorLabel;

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorDividePresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final DivideService service = GWT.create(DivideService.class);

    /**
     * Constructeur
     */
    public CalculatorDividePresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        boutonClear.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valDividende.setText("");
                valDiviseur.setText("");
                errorLabel.setText("Valeurs supprimé!");
            }
        });
        boutonDivide.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                divide();
            }
        });
    }
    /**
     * call server
     */
    private void divide() {
        int dividende = Integer.parseInt(valDividende.getText());
        int diviseur = Integer.parseInt(valDiviseur.getText());
   try
        {
            int result = service.divide(dividende, diviseur);
            errorLabel.setText("");
                String title = "Résultat de la division";
                String operation = valDividende.getText() + " / " + valDiviseur.getText();
                String resultStr = String.valueOf(valDiviseur.getText());
                DialogBoxInssetPresenter dialogBoxInssetPresenter = new DialogBoxInssetPresenter(title, operation, resultStr);
        }
        catch (IllegalArgumentException e)
        {
            errorLabel.getElement().getStyle().setColor("red");
            errorLabel.setText(e.getMessage());
            //errorLabel.setText("Impossible d'effectuer la division, vérifiez le diviseur et le dividende!");
        }
        
    }
}
