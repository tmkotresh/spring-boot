package springbootdemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.validation.annotation.Validated;

import com.sun.istack.NotNull;

@Validated
@Entity
@Table(name = EmployeeEntity.TABLE_NAME)
public class EmployeeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	  static final String TABLE_NAME = "TBL_EMPLOYEE";
	  
	 
	  private abstract static class Sequence {
		    private Sequence() {}

		    public static final String GENERATOR_NAME = "EmployeeSequence";
		    public static final String STRATEGY = "org.hibernate.id.enhanced.SequenceStyleGenerator";

		    private abstract static class Parameters {
		      private Parameters() {}

		      public static final String PRM_SEQUENCE_NAME = "sequence_name";
		      public static final String SEQUENCE_NAME = "SEQ_EMPLOYEE";
		      public static final String PRM_INITIAL_VALUE = "initial_value";
		      public static final String INITIAL_VALUE = "1";
		      public static final String PRM_INCREMENT_SIZE = "increment_size";
		      public static final String INCREMENT_SIZE = "1";
		    }
		  }
	  
	  private abstract static class Columns {
		    private Columns() {}

		    public static final String ID = "ID";
		    public static final String NAME = "NAME";
	  }
	  
	  @Id
	  @GenericGenerator(name = Sequence.GENERATOR_NAME, strategy = Sequence.STRATEGY,
	      parameters = {
	          @Parameter(name = Sequence.Parameters.PRM_SEQUENCE_NAME,
	              value = Sequence.Parameters.SEQUENCE_NAME),
	          @Parameter(name = Sequence.Parameters.PRM_INITIAL_VALUE,
	              value = Sequence.Parameters.INITIAL_VALUE),
	          @Parameter(name = Sequence.Parameters.PRM_INCREMENT_SIZE,
	              value = Sequence.Parameters.INCREMENT_SIZE)})
	  @GeneratedValue(generator = Sequence.GENERATOR_NAME, strategy = GenerationType.SEQUENCE)
	  @Column(name = Columns.ID)
	  private Long id;
	  
	  @NotNull
	  @Column(name = Columns.NAME)
	  private String name;
}
