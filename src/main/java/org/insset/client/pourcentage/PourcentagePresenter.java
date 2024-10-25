package org.insset.client.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.DiscountService;
import org.insset.client.service.DiscountServiceAsync;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author talend
 */
public class PourcentagePresenter extends Composite {

    @UiField
    public ResetButton buttonClearP;
    @UiField
    public ResetButton buttonClearD;
    @UiField
    public SubmitButton buttonConvert;
    @UiField
    public TextBox valPrice;
    @UiField
    public TextBox valDiscount;
    @UiField
    public Label errorLabelP;
    @UiField
    public Label errorLabelD;
    @UiField
    public Label errorLabelC;

    interface MainUiBinder extends UiBinder<HTMLPanel, PourcentagePresenter> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final DiscountServiceAsync service = GWT.create(DiscountService.class);

    /**
     * Constructeur
     */
    public PourcentagePresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        buttonClearP.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valPrice.setText("");
                errorLabelP.setText("");
            }
        });
        
        buttonClearD.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                valDiscount.setText("");
                errorLabelD.setText("");
            }
        });
        
        buttonConvert.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                convertDiscount();
            }
        });
    }
    
    private void convertDiscount() {
        errorLabelC.setText("");
        
        // Get input values
        String priceText = valPrice.getText();
        String discountText = valDiscount.getText();

        // Validate inputs
        final Integer price = parseInteger(priceText, errorLabelP, "Invalid price format. Please enter a number.");
        final Integer discount = parseInteger(discountText, errorLabelD, "Invalid discount format. Please enter a number.");
        
        if (price == null || discount == null) {
            return; // Stop if inputs are invalid
        }

        // Call the service to get the discount amount
        service.getDiscountAmount(price, discount, new AsyncCallback<Integer>() {
            @Override
            public void onFailure(Throwable caught) {
                errorLabelC.addStyleName("serverResponseLabelError");
                errorLabelC.setText("Failed to calculate discount: " + caught.getMessage());
            }
            
            @Override
            public void onSuccess(final Integer discountAmount) {
                // Call the service to get the price after discount
                service.getPriceAfterDiscount(price, discount, new AsyncCallback<Integer>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        errorLabelC.addStyleName("serverResponseLabelError");
                        errorLabelC.setText("Failed to calculate final price: " + caught.getMessage());
                    }
                    
                    @Override
                    public void onSuccess(Integer finalPrice) {
                        // Display the results in a dialog
                        showResultsDialog(discountAmount, finalPrice);
                    }
                });
            }
        });
    }
    
    private Integer parseInteger(String text, Label errorLabel, String errorMessage) {
        try {
            errorLabel.setText("");
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            errorLabel.setText(errorMessage);
            return null;
        }
    }
    
    private void showResultsDialog(Integer discountAmount, Integer finalPrice) {
        new DialogBoxInssetPresenter("Discount Results", "Discount Amount | Final Price", discountAmount + " | " + finalPrice);
    }
}
