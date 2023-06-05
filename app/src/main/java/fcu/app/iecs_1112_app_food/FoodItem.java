package fcu.app.iecs_1112_app_food;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FoodItem {
    private byte[] image;
    private String foodName;
    private int foodPrice;

    public FoodItem(byte[] image, String foodName, int foodPrice) {
        this.image = image;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public Bitmap getImage() {
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        return bitmap;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }
}
