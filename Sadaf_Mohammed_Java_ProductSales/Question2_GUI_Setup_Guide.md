# Create Question 2's GUI using NetBeans drag and drop

The supplied Java classes handle the calculations and actions:

- `IProductCalculations` and `ProductCalculations`: VAT (15%), commission (5%) and total sale amount (Q.2.5)
- `ProductAppController`: Process (shows the message and saves `data.txt`) and Clear

Create the form itself in **Design** view using the steps below. Do not paste layout code into `initComponents()`.

> The project already contains a finished `ProductAppForm` for reference. To build it yourself, first right-click `ProductAppForm.java` and choose **Delete**. This also removes its `.form` file.

## 1. Create a JFrame Form

1. Open the `ProductApp` Maven project in NetBeans (**File > Open Project**).
2. Expand **Source Packages > com.mycompany.productapp**.
3. Right-click that package and select **New > JFrame Form**. If it isn't listed, choose **New > Other > Swing GUI Forms > JFrame Form**.
4. Enter the class name **ProductAppForm**. The package is **com.mycompany.productapp**.
5. Click **Finish**, then select the **Design** tab.

NetBeans creates two linked files, `ProductAppForm.java` and `ProductAppForm.form`, and generates the component and layout code for you.

## 2. Set form properties

Select the JFrame in the **Navigator**. In **Properties** set:

| Property | Value |
| --- | --- |
| title | Product App |
| defaultCloseOperation | EXIT_ON_CLOSE |

Drag the form's lower-right corner to about 470 pixels wide and 300 pixels high. Leave the layout as the default **Free Design**.

## 3. Drag the controls from the Palette (Q.2.2)

If the Palette is hidden, open **Window > IDE Tools > Palette**. Drag these **Swing Controls** onto the JFrame. Put each label on the left and its input box to the right on the same row, and use the blue alignment guides so everything lines up.

To change a variable name, right-click the component and select **Change Variable Name**. Set the visible text in **Properties > text**.

| Palette control | Variable name | Text / properties |
| --- | --- | --- |
| Label | `lblCustomerName` | text: `Customer Name:` |
| Text Field | `txtCustomerName` | text: empty |
| Label | `lblProduct` | text: `Select Product:` |
| Combo Box | `cmbProduct` | model: `Cozy Nights Monarch`, `Restonic Barbados`, `Sealy Phuket` (see below) |
| Label | `lblPrice` | text: `Enter Price:` |
| Text Field | `txtPrice` | text: empty |
| Button | `btnProcess` | text: `PROCESS` |

- **Combo box items:** select `cmbProduct`, click the **...** next to **model**, replace `Item 1` to `Item 4` with the three mattresses (one per line), and click **OK**.
- **Text fields:** after clearing the text, drag each field's right edge out so it's as wide as the combo box.
- **Button:** place it under the price box and stretch it to the same width as the boxes above it, like the sample screenshot.

## 4. Build the menus using the Palette (Q.2.4)

1. Drag **Menu Bar** from **Swing Menus** onto the top of the JFrame.
2. A new Menu Bar starts with **File** and **Edit**. Leave File as it is, and change Edit's text to **Tools**. Also set the variable names: `mnuFile` and `mnuTools`.
3. Drag **Menu Item** controls into the menus and set their names and text:

| Parent menu | Variable name | Text |
| --- | --- | --- |
| File | `mnuExit` | Exit |
| Tools | `mnuProcess` | Process |
| Tools | `mnuClear` | Clear |

If dropping onto the menu is fiddly, right-click the menu in the **Navigator** and choose **Add From Palette > Menu Item** instead.

## 5. Add the controller field in Source view

Click **Source**. Find:

```java
public class ProductAppForm extends javax.swing.JFrame {
```

Immediately inside the class, above the constructor, add:

```java
private final ProductAppController controller = new ProductAppController();
```

Keep NetBeans' existing constructor and its `initComponents();` call. Do not change the generated component declarations or layout code. Everything below is event-handling code only.

## 6. Connect the Process button (Q.2.3)

Return to **Design** and double-click the **PROCESS** button. NetBeans creates `btnProcessActionPerformed`. Replace the `// TODO` line inside it with:

```java
controller.process(this, txtCustomerName, cmbProduct, txtPrice);
```

## 7. Connect the menu items (Q.2.4)

For each menu item, select it in the designer or Navigator, right-click it and choose **Events > Action > actionPerformed**. Replace the `// TODO` line in the generated handler with:

| Menu item | Handler body |
| --- | --- |
| Exit | `System.exit(0);` |
| Process | `controller.process(this, txtCustomerName, cmbProduct, txtPrice);` |
| Clear | `controller.clear(txtCustomerName, cmbProduct, txtPrice);` |

The **Process** menu item calls exactly the same method as the **PROCESS** button, which is what the question asks for. Paste only the line, inside the method NetBeans created. Don't paste a second copy of the method declaration.

## 8. Run the form

1. Save all files.
2. Right-click the project and choose **Clean and Build**.
3. Right-click the project and choose **Run**. If NetBeans asks for a main class, choose `com.mycompany.productapp.ProductAppForm`.

The JFrame template already includes a `main` method that opens the window. It launches the designer-created form and does not create the layout.

## 9. Check the required behaviour

1. Enter `Joe Bloggs`, choose **Cozy Nights Monarch**, enter `3500`, then click **PROCESS**. The message should show `VAT: R 525.0`, `COMMISSION: R 175.0` and `TOTAL: R 4200.0`.
2. Open the **Files** tab and refresh the project folder. Open `data.txt` and check the `DATA LOG` heading, the star lines and the five detail lines.
3. Select **Tools > Process**. It should behave exactly like the button.
4. Leave the name empty and process. You should get a message asking for the customer's name.
5. Enter `abc` or `0` as the price and process. You should get an error message instead of a crash.
6. Select **Tools > Clear**. Both text boxes should empty, and the combo box should go back to **Cozy Nights Monarch** (index 0).
7. Select **File > Exit**. The application closes.
8. Right-click the project and choose **Test**. All 3 tests should pass.
9. Reopen the **Design** tab to confirm the form can still be edited by drag and drop.

The `.java` file contains generated Swing component and layout code after you use the designer. That's normal, because NetBeans generates it from your drag-and-drop design. Keep the matching `.form` file, and change the GUI in **Design** view, never by rewriting that generated block by hand.
