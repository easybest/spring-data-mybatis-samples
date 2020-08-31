/*
 *
 *   Copyright 2016 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.springframework.data.mybatis.samples;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import javax.persistence.Entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mybatis.domain.LongId;
import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.data.mybatis.repository.config.EnableMybatisAuditing;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

@SpringBootApplication
@EnableMybatisAuditing
public class SpringDataMybatisSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMybatisSamplesApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummyCLR(ReservationRepository reservationRepository) {
		return args -> {
			Stream.of("Tom", "Jack", "Apple")
					.forEach(name -> reservationRepository.save(new Reservation(name, new Random().nextInt(9))));
		};
	}

	@Bean
	public AuditorAware<Long> auditorAware() {
		return () -> Optional.of(1L);
	}

}

@RepositoryRestResource(excerptProjection = ReservationProjection.class)
interface ReservationRepository extends MybatisRepository<Reservation, Long> {

}

@Projection(name = "reservationProjection", types = { Reservation.class })
interface ReservationProjection {

	String getReservationName();

}

@Entity
class Reservation extends LongId {

	private String reservationName;

	private Integer num;

	public Reservation() {
	}

	public Reservation(String reservationName) {
		this.reservationName = reservationName;
	}

	public Reservation(String reservationName, Integer num) {
		this(reservationName);
		this.num = num;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getReservationName() {
		return reservationName;
	}

	@Override
	public String toString() {
		return "Reservation{" + "reservationName='" + reservationName + '\'' + '}';
	}

}
