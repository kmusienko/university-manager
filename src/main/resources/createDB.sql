CREATE SCHEMA IF NOT EXISTS `universityDB` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `universityDB`.`faculties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(80) NOT NULL,
  `letter` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`specialities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `letter` VARCHAR(45) NOT NULL,
  `faculty_id` INT NOT NULL,
  INDEX `fk_specialities_faculties1_idx` (`faculty_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_specialities_faculties1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `universityDB`.`faculties` (`id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`cathedras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `faculty_id` INT NOT NULL,
  PRIMARY KEY (`id`, `faculty_id`),
  INDEX `fk_cathedras_faculties1_idx` (`faculty_id` ASC),
  CONSTRAINT `fk_cathedras_faculties1`
    FOREIGN KEY (`faculty_id`)
    REFERENCES `universityDB`.`faculties` (`id`)
    )
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`teachers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cathedras_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_teachers_cathedras1_idx` (`cathedras_id` ASC),
  CONSTRAINT `fk_teachers_cathedras1`
    FOREIGN KEY (`cathedras_id`)
    REFERENCES `universityDB`.`cathedras` (`id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`groups` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `curator_id` INT NOT NULL,
  `specialities_id` INT NOT NULL,
  `year_int` INT NOT NULL,
  `group_num` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_groups_teachers1_idx` (`curator_id` ASC),
  INDEX `fk_groups_specialities1_idx` (`specialities_id` ASC),
  CONSTRAINT `fk_groups_teachers1`
    FOREIGN KEY (`curator_id`)
    REFERENCES `universityDB`.`teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_groups_specialities1`
    FOREIGN KEY (`specialities_id`)
    REFERENCES `universityDB`.`specialities` (`id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`students` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `group_id` INT NOT NULL,
  `ind_number` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `birthday_date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `ind_number_UNIQUE` (`ind_number` ASC),
  INDEX `fk_students_groups1_idx` (`group_id` ASC),
  CONSTRAINT `fk_students_groups1`
    FOREIGN KEY (`group_id`)
    REFERENCES `universityDB`.`groups` (`id`)
)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`subjects` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `universityDB`.`plan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `teacher_id` INT NOT NULL,
  `group_id` INT NOT NULL,
  `subject_id` INT NOT NULL,
  `hours` INT NOT NULL,
  `semester_num` INT NOT NULL,
  `control` ENUM('ЗАЧЁТ', 'ДИФЗАЧЁТ', 'ЭКЗАМЕН') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_plan_teachers1_idx` (`teacher_id` ASC),
  INDEX `fk_plan_groups1_idx` (`group_id` ASC),
  INDEX `fk_plan_subjects1_idx` (`subject_id` ASC),
  CONSTRAINT `fk_plan_teachers1`
    FOREIGN KEY (`teacher_id`)
    REFERENCES `universityDB`.`teachers` (`id`),
  CONSTRAINT `fk_plan_groups1`
    FOREIGN KEY (`group_id`)
    REFERENCES `universityDB`.`groups` (`id`),
  CONSTRAINT `fk_plan_subjects1`
    FOREIGN KEY (`subject_id`)
    REFERENCES `universityDB`.`subjects` (`id`)
)
ENGINE = InnoDB;