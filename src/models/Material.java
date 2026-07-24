package models;

public class Material {
 
    private int materialId;
    private String materialName;
    private int quantity;
    private int reorderLevel;
 
    public Material() {
    }
 
    public Material(String materialId, String materialName, String quantity, String reorderLevel) {
        this.materialId = Integer.parseInt(materialId);
        this.materialName = materialName;
        this.quantity = Integer.parseInt(quantity);
        this.reorderLevel = Integer.parseInt(reorderLevel);
    }
 
   public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }
 
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
 
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
}
