package com.zadanie.exchange.frontend;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.zadanie.exchange.backend.Connection;

import java.io.IOException;

@Route
@HtmlImport("frontend://styles/shared-styles.html")
public class MainView extends Div {

    public MainView() throws IOException {

        H1 title = new H1("Select exchange currencies");
        setClassName("main-layout");

        HorizontalLayout currencyChooseLayout = new HorizontalLayout();

        Label fromLabel = new Label("From");
        Select<String> firstCurrencySelector = new Select<>();
        firstCurrencySelector.setItems(Connection.getValuesMap().keySet());
        Label toLabel = new Label("to");
        Select<String> secondCurrencySelector = new Select<>();
        secondCurrencySelector.setItems(Connection.getValuesMap().keySet());

        VerticalLayout exchangeRateLayout = new VerticalLayout();
        TextField exchangeRate = new TextField("Exchange Rate");
        exchangeRate.setReadOnly(true);
        Label actualCurrenciesLabel = new Label("");

        secondCurrencySelector.addValueChangeListener(e -> {
            actualCurrenciesLabel.setText(
                    firstCurrencySelector.getValue() + " <- -> "
                            + secondCurrencySelector.getValue());

            try {
                double firstValue = (double) Connection.getValuesMap().get(firstCurrencySelector.getValue());
                double secondValue = (double) Connection.getValuesMap().get(secondCurrencySelector.getValue());

                exchangeRate.setValue((1 * firstValue) / secondValue + "");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });


        exchangeRateLayout.add(exchangeRate, actualCurrenciesLabel);

        currencyChooseLayout.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, fromLabel, firstCurrencySelector, toLabel, secondCurrencySelector, exchangeRateLayout);
        currencyChooseLayout.add(fromLabel, firstCurrencySelector, toLabel, secondCurrencySelector, exchangeRateLayout);
        add(title, currencyChooseLayout);


    }
}
