package requestModel;

public class CreateOrder {
		 private int id;
		 private long petId;
		 private long quantity;
		 private String shipDate;
		 private String status;
		 private boolean complete;


		 // Getter Methods 

		 public int getId() {
		  return id;
		 }

		 public long getPetId() {
		  return petId;
		 }

		 public long getQuantity() {
		  return quantity;
		 }

		 public String getShipDate() {
		  return shipDate;
		 }

		 public String getStatus() {
		  return status;
		 }

		 public boolean getComplete() {
		  return complete;
		 }

		 // Setter Methods 

		 public void setId(int id) {
		  this.id = id;
		 }

		 public void setPetId(long petId) {
		  this.petId = petId;
		 }

		 public void setQuantity(long quantity) {
		  this.quantity = quantity;
		 }

		 public void setShipDate(String shipDate) {
		  this.shipDate = shipDate;
		 }

		 public void setStatus(String status) {
		  this.status = status;
		 }

		 public void setComplete(boolean complete) {
		  this.complete = complete;
		 }
		}


