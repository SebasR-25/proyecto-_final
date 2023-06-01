package pojo;

import java.util.List;

public class DataItem{
	private String thumbnail;
	private List<String> sources;
	private List<String> synonyms;
	private AnimeSeason animeSeason;
	private String title;
	private String type;
	private List<String> relations;
	private int episodes;
	private String picture;
	private String status;
	private List<String> tags;

	public String getThumbnail(){
		return thumbnail;
	}

	public List<String> getSources(){
		return sources;
	}

	public List<String> getSynonyms(){
		return synonyms;
	}

	public AnimeSeason getAnimeSeason(){
		return animeSeason;
	}

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public List<String> getRelations(){
		return relations;
	}

	public int getEpisodes(){
		return episodes;
	}

	public String getPicture(){
		return picture;
	}

	public String getStatus(){
		return status;
	}

	public List<String> getTags(){
		return tags;
	}
}