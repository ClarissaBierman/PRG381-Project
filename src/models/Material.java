package models;

public class Material {
 
    private String materialId;
    private String name;
    private String quantity;
    private String reorder;
 
    public Material() {
    }
 
    public Material(String materialId, String name, String quantity, String reorder) {
        this.materialId = materialId;
        this.name = name;
        this.quantity = quantity;
        this.reorder = reorder;
    }
 
    public String getMaterialId() {
        return materialId;
    }
 
    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getQuantity() {
        return quantity;
    }
 
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
 
    public String getReorder() {
        return reorder;
    }
 
    public void setReorder(String reorder) {
        this.reorder = reorder;
    }
}
