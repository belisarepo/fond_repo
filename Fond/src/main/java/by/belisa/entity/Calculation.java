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
	private int zpFull;
	@Column(name="ZP_FIRST_YEAR")
	private int zpFirstYear;
	@Column(name="FSZN_FULL")
	private int fsznFull;
	@Column(name="FSZN_FIRST_YEAR")
	private int fsznFirstYear;
	@Column(name="INSURANCE_FULL")
	private int insuranceFull;
	@Column(name="INSURANCE_FIRST_YEAR")
	private int insuranceFirstYear;
	@Column(name="HARDWARE_FULL")
	private int hardwareFull;
	@Column(name="HARDWARE_FIRST_YEAR")
	private int hardwareFirstYear;
	@Column(name="FUEL_FULL")
	private int fuelFull;
	@Column(name="FUEL_FIRST_YEAR")
	private int fuelFirstYear;
	@Column(name="EQUIPMENT_FULL")
	private int equipmentFull;
	@Column(name="EQUIPMENT_FIRST_YEAR")
	private int equipmentFirstYear;
	@Column(name="BUSINESS_TRIP_FULL")
	private int businessTripFull;
	@Column(name="BUSINESS_TRIP_FIRST_YEAR")
	private int businessTripFirstYear;
	@Column(name="THIRD_PARTY_SRVS_FULL")
	private int thirdPartyServicesFull;
	@Column(name="THIRD_PARTY_SRVS_FIRST_YEAR")
	private int thirdPartyServicesFirstYear;
	@Column(name="OTHER_FULL")
	private int otherFull;
	@Column(name="OTHER_FIRST_YEAR")
	private int otherFirstYear;
	@Column(name="OVERHEAD_FULL")
	private int overheadFull;
	@Column(name="OVERHEAD_FIRST_YEAR")
	private int overheadFirstYear;
	@Column(name="INNOVATION_FOND_FULL")
	private int innovationFondFull;
	@Column(name="INNOVATION_FOND_FIRST_YEAR")
	private int innovationFondFirstYear;
	@Column(name="PLANNED_COST_FULL")
	private int plannedCostFull;
	@Column(name="PLANNED_COST_FIRST_YEAR")
	private int plannedCostFirstYear;
	@Column(name="PROFIT_FULL")
	private int profitFull;
	@Column(name="PROFIT_FIRST_YEAR")
	private int profitFirstYear;
	@Column(name="ALL_FULL")
	private int allFull;
	@Column(name="ALL_FIRST_YEAR")
	private int allFirstYear;
	
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=false)  
	@PrimaryKeyJoinColumn()
	private ZayavkaFI zayavkaFI;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getZpFull() {
		return zpFull;
	}



	public void setZpFull(int znFull) {
		this.zpFull = znFull;
	}



	public int getZpFirstYear() {
		return zpFirstYear;
	}



	public void setZpFirstYear(int znFirstYear) {
		this.zpFirstYear = znFirstYear;
	}



	public int getFsznFull() {
		return fsznFull;
	}



	public void setFsznFull(int fsznFull) {
		this.fsznFull = fsznFull;
	}



	public int getFsznFirstYear() {
		return fsznFirstYear;
	}



	public void setFsznFirstYear(int fsznFirstYear) {
		this.fsznFirstYear = fsznFirstYear;
	}



	public int getInsuranceFull() {
		return insuranceFull;
	}



	public void setInsuranceFull(int insuranceFull) {
		this.insuranceFull = insuranceFull;
	}



	public int getInsuranceFirstYear() {
		return insuranceFirstYear;
	}



	public void setInsuranceFirstYear(int insuranceFirstYear) {
		this.insuranceFirstYear = insuranceFirstYear;
	}



	public int getHardwareFull() {
		return hardwareFull;
	}



	public void setHardwareFull(int hardwareFull) {
		this.hardwareFull = hardwareFull;
	}



	public int getHardwareFirstYear() {
		return hardwareFirstYear;
	}



	public void setHardwareFirstYear(int hardwareFirstYear) {
		this.hardwareFirstYear = hardwareFirstYear;
	}



	public int getFuelFull() {
		return fuelFull;
	}



	public void setFuelFull(int fuelFull) {
		this.fuelFull = fuelFull;
	}



	public int getFuelFirstYear() {
		return fuelFirstYear;
	}



	public void setFuelFirstYear(int fuelFirstYear) {
		this.fuelFirstYear = fuelFirstYear;
	}



	public int getEquipmentFull() {
		return equipmentFull;
	}



	public void setEquipmentFull(int equipmentFull) {
		this.equipmentFull = equipmentFull;
	}



	

	public int getEquipmentFirstYear() {
		return equipmentFirstYear;
	}



	public void setEquipmentFirstYear(int equipmentFirstYear) {
		this.equipmentFirstYear = equipmentFirstYear;
	}



	public int getBusinessTripFull() {
		return businessTripFull;
	}



	public void setBusinessTripFull(int businessTripFull) {
		this.businessTripFull = businessTripFull;
	}



	public int getBusinessTripFirstYear() {
		return businessTripFirstYear;
	}



	public void setBusinessTripFirstYear(int businessTripFirstYear) {
		this.businessTripFirstYear = businessTripFirstYear;
	}



	public int getThirdPartyServicesFull() {
		return thirdPartyServicesFull;
	}



	public void setThirdPartyServicesFull(int thirdPartyServicesFull) {
		this.thirdPartyServicesFull = thirdPartyServicesFull;
	}



	public int getThirdPartyServicesFirstYear() {
		return thirdPartyServicesFirstYear;
	}



	public void setThirdPartyServicesFirstYear(int thirdPartyServicesFirstYear) {
		this.thirdPartyServicesFirstYear = thirdPartyServicesFirstYear;
	}



	public int getOtherFull() {
		return otherFull;
	}



	public void setOtherFull(int otherFull) {
		this.otherFull = otherFull;
	}



	public int getOtherFirstYear() {
		return otherFirstYear;
	}



	public void setOtherFirstYear(int otherFirstYear) {
		this.otherFirstYear = otherFirstYear;
	}



	public int getOverheadFull() {
		return overheadFull;
	}



	public void setOverheadFull(int overheadFull) {
		this.overheadFull = overheadFull;
	}



	public int getOverheadFirstYear() {
		return overheadFirstYear;
	}



	public void setOverheadFirstYear(int overheadFirstYear) {
		this.overheadFirstYear = overheadFirstYear;
	}



	public int getInnovationFondFull() {
		return innovationFondFull;
	}



	public void setInnovationFondFull(int innovationFondFull) {
		this.innovationFondFull = innovationFondFull;
	}



	public int getInnovationFondFirstYear() {
		return innovationFondFirstYear;
	}



	public void setInnovationFondFirstYear(int innovationFondFirstYear) {
		this.innovationFondFirstYear = innovationFondFirstYear;
	}



	public int getPlannedCostFull() {
		return plannedCostFull;
	}



	public void setPlannedCostFull(int plannedCostFull) {
		this.plannedCostFull = plannedCostFull;
	}



	public int getPlannedCostFirstYear() {
		return plannedCostFirstYear;
	}



	public void setPlannedCostFirstYear(int plannedCostFirstYear) {
		this.plannedCostFirstYear = plannedCostFirstYear;
	}



	public int getProfitFull() {
		return profitFull;
	}



	public void setProfitFull(int profitFull) {
		this.profitFull = profitFull;
	}



	public int getProfitFirstYear() {
		return profitFirstYear;
	}



	public void setProfitFirstYear(int profitFirstYear) {
		this.profitFirstYear = profitFirstYear;
	}



	public int getAllFull() {
		return allFull;
	}



	public void setAllFull(int allFull) {
		this.allFull = allFull;
	}



	public int getAllFirstYear() {
		return allFirstYear;
	}



	public void setAllFirstYear(int allFirstYear) {
		this.allFirstYear = allFirstYear;
	}



	public ZayavkaFI getZayavkaFI() {
		return zayavkaFI;
	}



	public void setZayavkaFI(ZayavkaFI zayavkaFI) {
		this.zayavkaFI = zayavkaFI;
	}
	
	
}
