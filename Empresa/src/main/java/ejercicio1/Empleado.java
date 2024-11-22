package ejercicio1;

import java.util.Objects;

public class Empleado {
	int emp_no;
	String apellido;
	String oficio;
	String dir;
	String fecha_alt;
	float salario;
	float comision;
	int dept_no;

	@Override
	public int hashCode() {
		return Objects.hash(apellido, comision, dept_no, dir, emp_no, fecha_alt, oficio, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(apellido, other.apellido)
				&& Float.floatToIntBits(comision) == Float.floatToIntBits(other.comision) && dept_no == other.dept_no
				&& Objects.equals(dir, other.dir) && emp_no == other.emp_no
				&& Objects.equals(fecha_alt, other.fecha_alt) && Objects.equals(oficio, other.oficio)
				&& Float.floatToIntBits(salario) == Float.floatToIntBits(other.salario);
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getFecha_alt() {
		return fecha_alt;
	}

	public void setFecha_alt(String fecha_alt) {
		this.fecha_alt = fecha_alt;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	@Override
	public String toString() {
		return "Empleado [emp_no=" + emp_no + ", apellido=" + apellido + ", oficio=" + oficio + ", dir=" + dir
				+ ", fecha_alt=" + fecha_alt + ", salario=" + salario + ", comision=" + comision + ", dept_no="
				+ dept_no + "]";
	}

}
