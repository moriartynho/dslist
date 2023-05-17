package com.moriartynho.dslist.dto;

import org.springframework.beans.BeanUtils;

import com.moriartynho.dslist.entities.Game;

import jakarta.validation.constraints.NotBlank;

public class GameDTO {

	private Long id;
	@NotBlank
	private String title;
	@NotBlank
	private Integer year;
	@NotBlank
	private String genre;
	@NotBlank
	private String platforms;
	private Double score;
	@NotBlank
	private String imgUrl;
	@NotBlank
	private String shortDescription;
	@NotBlank
	private String longDescription;

	public GameDTO() {
	}

	public GameDTO(Game game) {
		BeanUtils.copyProperties(game, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
