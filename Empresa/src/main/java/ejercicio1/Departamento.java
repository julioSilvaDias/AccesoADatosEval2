package ejercicio1;

import java.util.Objects;

public class Departamento {
	int dept_no;
	String dnombre;
	String loc;
	@Override
	public int hashCode() {
		return Objects.hash(dept_no, dnombre, loc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return dept_no == other.dept_no && Objects.equals(dnombre, other.dnombre) && Objects.equals(loc, other.loc);
	}
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public String getDnombre() {
		return dnombre;
	}
	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Departamento [dept_no=" + dept_no + ", dnombre=" + dnombre + ", loc=" + loc + "]";
	}
	
	
	
	
}
