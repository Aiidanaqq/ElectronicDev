package com.example.electronicdevices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

// Контроллер для управления GUI
public class HelloController {

    @FXML
    private TabPane tabPane;

    // Поля для смартфонов
    @FXML
    private TextField smartphoneNameField, smartphonePriceField, smartphoneWeightField, smartphoneScreenSizeField, smartphoneCameraResolutionField;
    // Поля для ноутбуков
    @FXML
    private TextField laptopNameField, laptopPriceField, laptopWeightField, laptopRamSizeField, laptopProcessorTypeField;
    // Поля для планшетов
    @FXML
    private TextField tabletNameField, tabletPriceField, tabletWeightField, tabletBatteryLifeField;
    @FXML
    private CheckBox tabletHasStylusCheckBox;
    @FXML
    private ListView<Device> listView;

    private final ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(devices); // Устанавливаем связь ListView с ObservableList
    }

    @FXML
    protected void onAddButtonClick() {
        try {
            // Получаем значения из полей в зависимости от выбранной вкладки
            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            String selectedTabText = selectedTab.getText();

            String name = getNameByTab(selectedTabText);
            double price = getPriceByTab(selectedTabText);
            double weight = getWeightByTab(selectedTabText);

            switch (selectedTabText) {
                case "Smartphone" -> {
                    double screenSize = parseDouble(smartphoneScreenSizeField, "Screen Size");
                    double cameraResolution = parseDouble(smartphoneCameraResolutionField, "Camera Resolution");
                    devices.add(new Smartphone(name, price, weight, screenSize, cameraResolution));
                }
                case "Laptop" -> {
                    int ramSize = parseInt(laptopRamSizeField, "RAM Size");
                    String processorType = laptopProcessorTypeField.getText();
                    if (processorType.isEmpty()) throw new IllegalArgumentException("Processor Type is required.");
                    devices.add(new Laptop(name, price, weight, ramSize, processorType));
                }
                case "Tablet" -> {
                    double batteryLife = parseDouble(tabletBatteryLifeField, "Battery Life");
                    boolean hasStylus = tabletHasStylusCheckBox.isSelected();
                    devices.add(new Tablet(name, price, weight, batteryLife, hasStylus));
                }
            }
            clearFields(); // Очищаем поля после добавления устройства
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter a valid number in the fields.");
        } catch (IllegalArgumentException e) {
            showAlert("Input Error", e.getMessage());
        }
    }

    @FXML
    protected void onRemoveButtonClick() {
        Device selectedDevice = listView.getSelectionModel().getSelectedItem();
        if (selectedDevice != null) {
            devices.remove(selectedDevice);
        } else {
            showAlert("Selection Error", "Please select a device to remove.");
        }
    }

    private void clearFields() {
        // Очищаем поля для всех типов устройств
        smartphoneNameField.clear();
        smartphonePriceField.clear();
        smartphoneWeightField.clear();
        smartphoneScreenSizeField.clear();
        smartphoneCameraResolutionField.clear();

        laptopNameField.clear();
        laptopPriceField.clear();
        laptopWeightField.clear();
        laptopRamSizeField.clear();
        laptopProcessorTypeField.clear();

        tabletNameField.clear();
        tabletPriceField.clear();
        tabletWeightField.clear();
        tabletBatteryLifeField.clear();

        tabletHasStylusCheckBox.setSelected(false);
    }

    private double parseDouble(TextField field, String fieldName) throws IllegalArgumentException {
        String text = field.getText();
        if (text.isEmpty()) throw new IllegalArgumentException(fieldName + " is required.");
        return Double.parseDouble(text);
    }

    private int parseInt(TextField field, String fieldName) throws IllegalArgumentException {
        String text = field.getText();
        if (text.isEmpty()) throw new IllegalArgumentException(fieldName + " is required.");
        return Integer.parseInt(text);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private String getNameByTab(String selectedTabText) throws IllegalArgumentException {
        return switch (selectedTabText) {
            case "Smartphone" -> smartphoneNameField.getText();
            case "Laptop" -> laptopNameField.getText();
            case "Tablet" -> tabletNameField.getText();
            default -> throw new IllegalArgumentException("Invalid device type.");
        };
    }

    private double getPriceByTab(String selectedTabText) throws IllegalArgumentException {
        return switch (selectedTabText) {
            case "Smartphone" -> parseDouble(smartphonePriceField, "Price");
            case "Laptop" -> parseDouble(laptopPriceField, "Price");
            case "Tablet" -> parseDouble(tabletPriceField, "Price");
            default -> throw new IllegalArgumentException("Invalid device type.");
        };
    }

    private double getWeightByTab(String selectedTabText) throws IllegalArgumentException {
        return switch (selectedTabText) {
            case "Smartphone" -> parseDouble(smartphoneWeightField, "Weight");
            case "Laptop" -> parseDouble(laptopWeightField, "Weight");
            case "Tablet" -> parseDouble(tabletWeightField, "Weight");
            default -> throw new IllegalArgumentException("Invalid device type.");
        };
    }
}
