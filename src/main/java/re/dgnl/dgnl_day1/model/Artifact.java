package re.dgnl.dgnl_day1.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "artifact")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên không được trống")
    @Size(min = 5, max = 150, message = "Tên phải từ 5-150 kí tự")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Nguồn gốc không được để trống")
    @Column (name = "origin")
    private String origin;

    @NotNull(message = "ngày không được để trống")
    @PastOrPresent(message = "Không được là ngayfntrong tương lai")
    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
