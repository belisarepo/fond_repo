package by.belisa.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="CALCULATION")
@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "zayavkaFI"))
public class Calculation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6960456053099674438L;
	
	@Id
	@Column(name = "id")  
	@GeneratedValue(generator = "gen")  
	private Integer id;
	@Column(name="ZP_FULL")
	private float zpFull;
	@Column(name="ZP_FIRST_YEAR")
	private float zpFirstYear;
	@Column(name="FSZN_FULL")
	private float fsznFull;
	@Column(name="FSZN_FIRST_YEAR")
	private float fsznFirstYear;
	@Column(name="INSURANCE_FULL")
	private float insuranceFull;
	@Column(name="INSURANCE_FIRST_YEAR")
	private float insuranceFirstYear;
	@Column(name="HARDWARE_FULL")
	private float hardwareFull;
	@Column(name="HARDWARE_FIRST_YEAR")
	private float hardwareFirstYear;
	@Column(name="FUEL_FULL")
	private float fuelFull;
	@Column(name="FUEL_FIRST_YEAR")
	private float fuelFirstYear;
	@Column(name="EQUIPMENT_FULL")
	private float equipmentFull;
	@Column(name="EQUIPMENT_FIRST_YEAR")
	private float equipmentFirstYear;
	@Column(name="BUSINESS_TRIP_FULL")
	private float businessTripFull;
	@Column(name="BUSINESS_TRIP_FIRST_YEAR")
	private float businessTripFirstYear;
	@Column(name="THIRD_PARTY_SRVS_FULL")
	private float thirdPartyServicesFull;
	@Column(name="THIRD_PARTY_SRVS_FIRST_YEAR")
	private float thirdPartyServicesFirstYear;
	@Column(name="OTHER_FULL")
	private float otherFull;
	@Column(name="OTHER_FIRST_YEAR")
	private float otherFirstYear;
	@Column(name="OVERHEAD_FULL")
	private float overheadFull;
	@Column(name="OVERHEAD_FIRST_YEAR")
	private float overheadFirstYear;
	@Column(name="INNOVATION_FOND_FULL")
	private float innovationFondFull;
	@Column(name="INNOVATION_FOND_FIRST_YEAR")
	private float innovationFondFirstYear;
	@Column(name="PLANNED_COST_FULL")
	private float plannedCostFull;
	@Column(name="PLANNED_COST_FIRST_YEAR")
	private float plannedCostFirstYear;
	@Column(name="PROFIT_FULL")
	private float profitFull;
	@Column(name="PROFIT_FIRST_YEAR")
	private float profitFirstYear;
	@Column(name="ALL_FULL")
	private float allFull;
	@Column(name="ALL_FIRST_YEAR")
	private float allFirstYear;
	
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public float getZpFull() {
		return zpFull;
	}



	public void setZpFull(float znFull) {
		this.zpFull = znFull;
	}



	public float getZpFirstYear() {
		return zpFirstYear;
	}



	public void setZpFirstYear(float znFirstYear) {
		this.zpFirstYear = znFirstYear;
	}



	public float getFsznFull() {
		return fsznFull;
	}



	public void setFsznFull(float fsznFull) {
		this.fsznFull = fsznFull;
	}



	public float getFsznFirstYear() {
		return fsznFirstYear;
	}



	public void setFsznFirstYear(float fsznFirstYear) {
		this.fsznFirstYear = fsznFirstYear;
	}



	public float getInsuranceFull() {
		return insuranceFull;
	}



	public void setInsuranceFull(float insuranceFull) {
		this.insuranceFull = insuranceFull;
	}



	public float getInsuranceFirstYear() {
		return insuranceFirstYear;
	}



	public void setInsuranceFirstYear(float insuranceFirstYear) {
		this.insuranceFirstYear = insuranceFirstYear;
	}



	public float getHardwareFull() {
		return hardwareFull;
	}



	public void setHardwareFull(float hardwareFull) {
		this.hardwareFull = hardwareFull;
	}



	public float getHardwareFirstYear() {
		return hardwareFirstYear;
	}



	public void setHardwareFirstYear(float hardwareFirstYear) {
		this.hardwareFirstYear = hardwareFirstYear;
	}



	public float getFuelFull() {
		return fuelFull;
	}



	public void setFuelFull(float fuelFull) {
		this.fuelFull = fuelFull;
	}



	public float getFuelFirstYear() {
		return fuelFirstYear;
	}



	public void setFuelFirstYear(float fuelFirstYear) {
		this.fuelFirstYear = fuelFirstYear;
	}



	public float getEquipmentFull() {
		return equipmentFull;
	}



	public void setEquipmentFull(float equipmentFull) {
		this.equipmentFull = equipmentFull;
	}



	

	public float getEquipmentFirstYear() {
		return equipmentFirstYear;
	}



	public void setEquipmentFirstYear(float equipmentFirstYear) {
		this.equipmentFirstYear = equipmentFirstYear;
	}



	public float getBusinessTripFull() {
		return businessTripFull;
	}



	public void setBusinessTripFull(float businessTripFull) {
		this.businessTripFull = businessTripFull;
	}



	public float getBusinessTripFirstYear() {
		return businessTripFirstYear;
	}



	public void setBusinessTripFirstYear(float businessTripFirstYear) {
		this.businessTripFirstYear = businessTripFirstYear;
	}



	public float getThirdPartyServicesFull() {
		return thirdPartyServicesFull;
	}



	public void setThirdPartyServicesFull(float thirdPartyServicesFull) {
		this.thirdPartyServicesFull = thirdPartyServicesFull;
	}



	public float getThirdPartyServicesFirstYear() {
		return thirdPartyServicesFirstYear;
	}



	public void setThirdPartyServicesFirstYear(float thirdPartyServicesFirstYear) {
		this.thirdPartyServicesFirstYear = thirdPartyServicesFirstYear;
	}



	public float getOtherFull() {
		return otherFull;
	}



	public void setOtherFull(float otherFull) {
		this.otherFull = otherFull;
	}



	public float getOtherFirstYear() {
		return otherFirstYear;
	}



	public void setOtherFirstYear(float otherFirstYear) {
		this.otherFirstYear = otherFirstYear;
	}



	public float getOverheadFull() {
		return overheadFull;
	}



	public void setOverheadFull(float overheadFull) {
		this.overheadFull = overheadFull;
	}



	public float getOverheadFirstYear() {
		return overheadFirstYear;
	}



	public void setOverheadFirstYear(float overheadFirstYear) {
		this.overheadFirstYear = overheadFirstYear;
	}



	public float getInnovationFondFull() {
		return innovationFondFull;
	}



	public void setInnovationFondFull(float innovationFondFull) {
		this.innovationFondFull = innovationFondFull;
	}



	public float getInnovationFondFirstYear() {
		return innovationFondFirstYear;
	}



	public void setInnovationFondFirstYear(float innovationFondFirstYear) {
		this.innovationFondFirstYear = innovationFondFirstYear;
	}



	public float getPlannedCostFull() {
		return plannedCostFull;
	}



	public void setPlannedCostFull(float plannedCostFull) {
		this.plannedCostFull = plannedCostFull;
	}



	public float getPlannedCostFirstYear() {
		return plannedCostFirstYear;
	}



	public void setPlannedCostFirstYear(float plannedCostFirstYear) {
		this.plannedCostFirstYear = plannedCostFirstYear;
	}



	public float getProfitFull() {
		return profitFull;
	}



	public void setProfitFull(float profitFull) {
		this.profitFull = profitFull;
	}



	public float getProfitFirstYear() {
		return profitFirstYear;
	}



	public void setProfitFirstYear(float profitFirstYear) {
		this.profitFirstYear = profitFirstYear;
	}



	public float getAllFull() {
		return allFull;
	}



	public void setAllFull(float allFull) {
		this.allFull = allFull;
	}



	public float getAllFirstYear() {
		return allFirstYear;
	}



	public void setAllFirstYear(float allFirstYear) {
		this.allFirstYear = allFirstYear;
	}



	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}



	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
	
}
