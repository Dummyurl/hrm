package com.ourdesignz.hrm.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "isSuccess",
        "errorType",
        "data"
})
public class ExamplePOJO {

    @JsonProperty("isSuccess")
    private Boolean isSuccess;
    @JsonProperty("errorType")
    private String errorType;
    @JsonProperty("data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The isSuccess
     */
    @JsonProperty("isSuccess")
    public Boolean getIsSuccess() {
        return isSuccess;
    }

    /**
     * @param isSuccess The isSuccess
     */
    @JsonProperty("isSuccess")
    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * @return The errorType
     */
    @JsonProperty("errorType")
    public String getErrorType() {
        return errorType;
    }

    /**
     * @param errorType The errorType
     */
    @JsonProperty("errorType")
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    /**
     * @return The data
     */
    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    /**
     * @param data The data
     */
    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "matches",
            "total"
    })
    public class Data {

        @JsonProperty("matches")
        private List<Match> matches = new ArrayList<Match>();
        @JsonProperty("total")
        private Integer total;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The matches
         */
        @JsonProperty("matches")
        public List<Match> getMatches() {
            return matches;
        }

        /**
         * @param matches The matches
         */
        @JsonProperty("matches")
        public void setMatches(List<Match> matches) {
            this.matches = matches;
        }

        /**
         * @return The total
         */
        @JsonProperty("total")
        public Integer getTotal() {
            return total;
        }

        /**
         * @param total The total
         */
        @JsonProperty("total")
        public void setTotal(Integer total) {
            this.total = total;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "home_team",
            "away_team",
            "league_id",
            "match_date",
            "round",
            "year",
            "result_type",
            "is_half_time",
            "half_time_result",
            "half_time_home_score",
            "half_time_away_score",
            "odds",
            "live_minute",
            "home_goals",
            "away_goals",
            "events",
            "analysis",
            "forecastCount",
            "country"
    })
    public class Match {

        @JsonProperty("id")
        private String id;
        @JsonProperty("home_team")
        private HomeTeam home_team;
        @JsonProperty("away_team")
        private AwayTeam away_team;
        @JsonProperty("league_id")
        private LeagueId league_id;
        @JsonProperty("match_date")
        private String match_date;
        @JsonProperty("round")
        private Integer round;
        @JsonProperty("year")
        private Integer year;
        @JsonProperty("result_type")
        private String result_type;
        @JsonProperty("is_half_time")
        private Boolean is_half_time;
        @JsonProperty("half_time_result")
        private String half_time_result;
        @JsonProperty("half_time_home_score")
        private Integer half_time_home_score;
        @JsonProperty("half_time_away_score")
        private Integer half_time_away_score;
        @JsonProperty("odds")
        private Odds odds;
        @JsonProperty("live_minute")
        private Integer live_minute;
        @JsonProperty("home_goals")
        private Integer home_goals;
        @JsonProperty("away_goals")
        private Integer away_goals;
        @JsonProperty("events")
        private List<Event> events = new ArrayList<Event>();
        @JsonProperty("analysis")
        private Analysis analysis;
        @JsonProperty("forecastCount")
        private Integer forecastCount;
        @JsonProperty("country")
        private Country country;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The homeTeam
         */
        @JsonProperty("home_team")
        public HomeTeam getHomeTeam() {
            return home_team;
        }

        /**
         * @param homeTeam The home_team
         */
        @JsonProperty("home_team")
        public void setHomeTeam(HomeTeam home_team) {
            this.home_team = home_team;
        }

        /**
         * @return The awayTeam
         */
        @JsonProperty("away_team")
        public AwayTeam getAwayTeam() {
            return away_team;
        }

        /**
         * @param awayTeam The away_team
         */
        @JsonProperty("away_team")
        public void setAwayTeam(AwayTeam away_team) {
            this.away_team = away_team;
        }

        /**
         * @return The leagueId
         */
        @JsonProperty("league_id")
        public LeagueId getLeagueId() {
            return league_id;
        }

        /**
         * @param leagueId The league_id
         */
        @JsonProperty("league_id")
        public void setLeagueId(LeagueId league_id) {
            this.league_id = league_id;
        }

        /**
         * @return The matchDate
         */
        @JsonProperty("match_date")
        public String getMatchDate() {
            return match_date;
        }

        /**
         * @param matchDate The match_date
         */
        @JsonProperty("match_date")
        public void setMatchDate(String match_date) {
            this.match_date = match_date;
        }

        /**
         * @return The round
         */
        @JsonProperty("round")
        public Integer getRound() {
            return round;
        }

        /**
         * @param round The round
         */
        @JsonProperty("round")
        public void setRound(Integer round) {
            this.round = round;
        }

        /**
         * @return The year
         */
        @JsonProperty("year")
        public Integer getYear() {
            return year;
        }

        /**
         * @param year The year
         */
        @JsonProperty("year")
        public void setYear(Integer year) {
            this.year = year;
        }

        /**
         * @return The resultType
         */
        @JsonProperty("result_type")
        public String getResultType() {
            return result_type;
        }

        /**
         * @param resultType The result_type
         */
        @JsonProperty("result_type")
        public void setResultType(String result_type) {
            this.result_type = result_type;
        }

        /**
         * @return The isHalfTime
         */
        @JsonProperty("is_half_time")
        public Boolean getIsHalfTime() {
            return is_half_time;
        }

        /**
         * @param isHalfTime The is_half_time
         */
        @JsonProperty("is_half_time")
        public void setIsHalfTime(Boolean is_half_time) {
            this.is_half_time = is_half_time;
        }

        /**
         * @return The halfTimeResult
         */
        @JsonProperty("half_time_result")
        public String getHalfTimeResult() {
            return half_time_result;
        }

        /**
         * @param halfTimeResult The half_time_result
         */
        @JsonProperty("half_time_result")
        public void setHalfTimeResult(String half_time_result) {
            this.half_time_result = half_time_result;
        }

        /**
         * @return The halfTimeHomeScore
         */
        @JsonProperty("half_time_home_score")
        public Integer getHalfTimeHomeScore() {
            return half_time_home_score;
        }

        /**
         * @param halfTimeHomeScore The half_time_home_score
         */
        @JsonProperty("half_time_home_score")
        public void setHalfTimeHomeScore(Integer half_time_home_score) {
            this.half_time_home_score = half_time_home_score;
        }

        /**
         * @return The halfTimeAwayScore
         */
        @JsonProperty("half_time_away_score")
        public Integer getHalfTimeAwayScore() {
            return half_time_away_score;
        }

        /**
         * @param halfTimeAwayScore The half_time_away_score
         */
        @JsonProperty("half_time_away_score")
        public void setHalfTimeAwayScore(Integer half_time_away_score) {
            this.half_time_away_score = half_time_away_score;
        }

        /**
         * @return The odds
         */
        @JsonProperty("odds")
        public Odds getOdds() {
            return odds;
        }

        /**
         * @param odds The odds
         */
        @JsonProperty("odds")
        public void setOdds(Odds odds) {
            this.odds = odds;
        }

        /**
         * @return The liveMinute
         */
        @JsonProperty("live_minute")
        public Integer getLiveMinute() {
            return live_minute;
        }

        /**
         * @param liveMinute The live_minute
         */
        @JsonProperty("live_minute")
        public void setLiveMinute(Integer live_minute) {
            this.live_minute = live_minute;
        }

        /**
         * @return The homeGoals
         */
        @JsonProperty("home_goals")
        public Integer getHomeGoals() {
            return home_goals;
        }

        /**
         * @param homeGoals The home_goals
         */
        @JsonProperty("home_goals")
        public void setHomeGoals(Integer home_goals) {
            this.home_goals = home_goals;
        }

        /**
         * @return The awayGoals
         */
        @JsonProperty("away_goals")
        public Integer getAwayGoals() {
            return away_goals;
        }

        /**
         * @param awayGoals The away_goals
         */
        @JsonProperty("away_goals")
        public void setAwayGoals(Integer away_goals) {
            this.away_goals = away_goals;
        }

        /**
         * @return The events
         */
        @JsonProperty("events")
        public List<Event> getEvents() {
            return events;
        }

        /**
         * @param events The events
         */
        @JsonProperty("events")
        public void setEvents(List<Event> events) {
            this.events = events;
        }

        /**
         * @return The analysis
         */
        @JsonProperty("analysis")
        public Analysis getAnalysis() {
            return analysis;
        }

        /**
         * @param analysis The analysis
         */
        @JsonProperty("analysis")
        public void setAnalysis(Analysis analysis) {
            this.analysis = analysis;
        }

        /**
         * @return The forecastCount
         */
        @JsonProperty("forecastCount")
        public Integer getForecastCount() {
            return forecastCount;
        }

        /**
         * @param forecastCount The forecastCount
         */
        @JsonProperty("forecastCount")
        public void setForecastCount(Integer forecastCount) {
            this.forecastCount = forecastCount;
        }

        /**
         * @return The country
         */
        @JsonProperty("country")
        public Country getCountry() {
            return country;
        }

        /**
         * @param country The country
         */
        @JsonProperty("country")
        public void setCountry(Country country) {
            this.country = country;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "event_type",
            "team",
            "player_alias",
            "player_rs_id",
            "player",
            "minute"
    })
    public class Event {

        @JsonProperty("event_type")
        private String event_type;
        @JsonProperty("team")
        private Integer team;
        @JsonProperty("player_alias")
        private String player_alias;
        @JsonProperty("player_rs_id")
        private String player_rs_id;
        @JsonProperty("player")
        private String player;
        @JsonProperty("minute")
        private Integer minute;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The eventType
         */
        @JsonProperty("event_type")
        public String getEventType() {
            return event_type;
        }

        /**
         * @param eventType The event_type
         */
        @JsonProperty("event_type")
        public void setEventType(String event_type) {
            this.event_type = event_type;
        }

        /**
         * @return The team
         */
        @JsonProperty("team")
        public Integer getTeam() {
            return team;
        }

        /**
         * @param team The team
         */
        @JsonProperty("team")
        public void setTeam(Integer team) {
            this.team = team;
        }

        /**
         * @return The playerAlias
         */
        @JsonProperty("player_alias")
        public String getPlayerAlias() {
            return player_alias;
        }

        /**
         * @param playerAlias The player_alias
         */
        @JsonProperty("player_alias")
        public void setPlayerAlias(String player_alias) {
            this.player_alias = player_alias;
        }

        /**
         * @return The playerRsId
         */
        @JsonProperty("player_rs_id")
        public String getPlayerRsId() {
            return player_rs_id;
        }

        /**
         * @param playerRsId The player_rs_id
         */
        @JsonProperty("player_rs_id")
        public void setPlayerRsId(String player_rs_id) {
            this.player_rs_id = player_rs_id;
        }

        /**
         * @return The player
         */
        @JsonProperty("player")
        public String getPlayer() {
            return player;
        }

        /**
         * @param player The player
         */
        @JsonProperty("player")
        public void setPlayer(String player) {
            this.player = player;
        }

        /**
         * @return The minute
         */
        @JsonProperty("minute")
        public Integer getMinute() {
            return minute;
        }

        /**
         * @param minute The minute
         */
        @JsonProperty("minute")
        public void setMinute(Integer minute) {
            this.minute = minute;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "team_name",
            "team_name_tr",
            "resultados_id",
            "short_name",
            "stadium",
            "color1",
            "color2",
            "team_logos",
            "seo_name"
    })
    public class HomeTeam {

        @JsonProperty("id")
        private String id;
        @JsonProperty("team_name")
        private String team_name;
        @JsonProperty("team_name_tr")
        private String team_name_tr;
        @JsonProperty("resultados_id")
        private Integer resultados_id;
        @JsonProperty("short_name")
        private String short_name;
        @JsonProperty("stadium")
        private Stadium stadium;
        @JsonProperty("color1")
        private String color1;
        @JsonProperty("color2")
        private String color2;
        @JsonProperty("team_logos")
        private List<String> team_logos = new ArrayList<String>();
        @JsonProperty("seo_name")
        private String seo_name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The teamName
         */
        @JsonProperty("team_name")
        public String getTeamName() {
            return team_name;
        }

        /**
         * @param teamName The team_name
         */
        @JsonProperty("team_name")
        public void setTeamName(String team_name) {
            this.team_name = team_name;
        }

        /**
         * @return The teamNameTr
         */
        @JsonProperty("team_name_tr")
        public String getTeamNameTr() {
            return team_name_tr;
        }

        /**
         * @param teamNameTr The team_name_tr
         */
        @JsonProperty("team_name_tr")
        public void setTeamNameTr(String team_name_tr) {
            this.team_name_tr = team_name_tr;
        }

        /**
         * @return The resultadosId
         */
        @JsonProperty("resultados_id")
        public Integer getResultadosId() {
            return resultados_id;
        }

        /**
         * @param resultadosId The resultados_id
         */
        @JsonProperty("resultados_id")
        public void setResultadosId(Integer resultados_id) {
            this.resultados_id = resultados_id;
        }

        /**
         * @return The shortName
         */
        @JsonProperty("short_name")
        public String getShortName() {
            return short_name;
        }

        /**
         * @param shortName The short_name
         */
        @JsonProperty("short_name")
        public void setShortName(String short_name) {
            this.short_name = short_name;
        }

        /**
         * @return The stadium
         */
        @JsonProperty("stadium")
        public Stadium getStadium() {
            return stadium;
        }

        /**
         * @param stadium The stadium
         */
        @JsonProperty("stadium")
        public void setStadium(Stadium stadium) {
            this.stadium = stadium;
        }

        /**
         * @return The color1
         */
        @JsonProperty("color1")
        public String getColor1() {
            return color1;
        }

        /**
         * @param color1 The color1
         */
        @JsonProperty("color1")
        public void setColor1(String color1) {
            this.color1 = color1;
        }

        /**
         * @return The color2
         */
        @JsonProperty("color2")
        public String getColor2() {
            return color2;
        }

        /**
         * @param color2 The color2
         */
        @JsonProperty("color2")
        public void setColor2(String color2) {
            this.color2 = color2;
        }

        /**
         * @return The teamLogos
         */
        @JsonProperty("team_logos")
        public List<String> getTeamLogos() {
            return team_logos;
        }

        /**
         * @param teamLogos The team_logos
         */
        @JsonProperty("team_logos")
        public void setTeamLogos(List<String> team_logos) {
            this.team_logos = team_logos;
        }

        /**
         * @return The seoName
         */
        @JsonProperty("seo_name")
        public String getSeoName() {
            return seo_name;
        }

        /**
         * @param seoName The seo_name
         */
        @JsonProperty("seo_name")
        public void setSeoName(String seo_name) {
            this.seo_name = seo_name;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "1",
            "2",
            "12",
            "han",
            "X",
            "1X",
            "X2"
    })
    public class Iddaa {

        @JsonProperty("1")
        private Double _1;
        @JsonProperty("2")
        private Integer _2;
        @JsonProperty("12")
        private Double _12;
        @JsonProperty("han")
        private String han;
        @JsonProperty("X")
        private Integer x;
        @JsonProperty("1X")
        private Double _1X;
        @JsonProperty("X2")
        private Double x2;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The _1
         */
        @JsonProperty("1")
        public Double get1() {
            return _1;
        }

        /**
         * @param _1 The 1
         */
        @JsonProperty("1")
        public void set1(Double _1) {
            this._1 = _1;
        }

        /**
         * @return The _2
         */
        @JsonProperty("2")
        public Integer get2() {
            return _2;
        }

        /**
         * @param _2 The 2
         */
        @JsonProperty("2")
        public void set2(Integer _2) {
            this._2 = _2;
        }

        /**
         * @return The _12
         */
        @JsonProperty("12")
        public Double get12() {
            return _12;
        }

        /**
         * @param _12 The 12
         */
        @JsonProperty("12")
        public void set12(Double _12) {
            this._12 = _12;
        }

        /**
         * @return The han
         */
        @JsonProperty("han")
        public String getHan() {
            return han;
        }

        /**
         * @param han The han
         */
        @JsonProperty("han")
        public void setHan(String han) {
            this.han = han;
        }

        /**
         * @return The x
         */
        @JsonProperty("X")
        public Integer getX() {
            return x;
        }

        /**
         * @param x The X
         */
        @JsonProperty("X")
        public void setX(Integer x) {
            this.x = x;
        }

        /**
         * @return The _1X
         */
        @JsonProperty("1X")
        public Double get1X() {
            return _1X;
        }

        /**
         * @param _1X The 1X
         */
        @JsonProperty("1X")
        public void set1X(Double _1X) {
            this._1X = _1X;
        }

        /**
         * @return The x2
         */
        @JsonProperty("X2")
        public Double getX2() {
            return x2;
        }

        /**
         * @param x2 The X2
         */
        @JsonProperty("X2")
        public void setX2(Double x2) {
            this.x2 = x2;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "league_name",
            "league_name_tr",
            "resultados_id",
            "order",
            "type",
            "teams",
            "sub_league",
            "current_round",
            "group_code",
            "phase",
            "playoff",
            "total_rounds",
            "year",
            "country_id",
            "active"
    })
    public class LeagueId {

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("league_name")
        private String league_name;
        @JsonProperty("league_name_tr")
        private String league_name_tr;
        @JsonProperty("resultados_id")
        private Integer resultados_id;
        @JsonProperty("order")
        private Integer order;
        @JsonProperty("type")
        private String type;
        @JsonProperty("teams")
        private List<Integer> teams = new ArrayList<Integer>();
        @JsonProperty("sub_league")
        private Boolean sub_league;
        @JsonProperty("current_round")
        private Integer current_round;
        @JsonProperty("group_code")
        private String group_code;
        @JsonProperty("phase")
        private String phase;
        @JsonProperty("playoff")
        private String playoff;
        @JsonProperty("total_rounds")
        private Integer total_rounds;
        @JsonProperty("year")
        private Integer year;
        @JsonProperty("country_id")
        private Integer country_id;
        @JsonProperty("active")
        private Boolean active;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         * @return The leagueName
         */
        @JsonProperty("league_name")
        public String getLeagueName() {
            return league_name;
        }

        /**
         * @param leagueName The league_name
         */
        @JsonProperty("league_name")
        public void setLeagueName(String league_name) {
            this.league_name = league_name;
        }

        /**
         * @return The leagueNameTr
         */
        @JsonProperty("league_name_tr")
        public String getLeagueNameTr() {
            return league_name_tr;
        }

        /**
         * @param leagueNameTr The league_name_tr
         */
        @JsonProperty("league_name_tr")
        public void setLeagueNameTr(String league_name_tr) {
            this.league_name_tr = league_name_tr;
        }

        /**
         * @return The resultadosId
         */
        @JsonProperty("resultados_id")
        public Integer getResultadosId() {
            return resultados_id;
        }

        /**
         * @param resultadosId The resultados_id
         */
        @JsonProperty("resultados_id")
        public void setResultadosId(Integer resultados_id) {
            this.resultados_id = resultados_id;
        }

        /**
         * @return The order
         */
        @JsonProperty("order")
        public Integer getOrder() {
            return order;
        }

        /**
         * @param order The order
         */
        @JsonProperty("order")
        public void setOrder(Integer order) {
            this.order = order;
        }

        /**
         * @return The type
         */
        @JsonProperty("type")
        public String getType() {
            return type;
        }

        /**
         * @param type The type
         */
        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @return The teams
         */
        @JsonProperty("teams")
        public List<Integer> getTeams() {
            return teams;
        }

        /**
         * @param teams The teams
         */
        @JsonProperty("teams")
        public void setTeams(List<Integer> teams) {
            this.teams = teams;
        }

        /**
         * @return The subLeague
         */
        @JsonProperty("sub_league")
        public Boolean getSubLeague() {
            return sub_league;
        }

        /**
         * @param subLeague The sub_league
         */
        @JsonProperty("sub_league")
        public void setSubLeague(Boolean sub_league) {
            this.sub_league = sub_league;
        }

        /**
         * @return The currentRound
         */
        @JsonProperty("current_round")
        public Integer getCurrentRound() {
            return current_round;
        }

        /**
         * @param currentRound The current_round
         */
        @JsonProperty("current_round")
        public void setCurrentRound(Integer current_round) {
            this.current_round = current_round;
        }

        /**
         * @return The groupCode
         */
        @JsonProperty("group_code")
        public String getGroupCode() {
            return group_code;
        }

        /**
         * @param groupCode The group_code
         */
        @JsonProperty("group_code")
        public void setGroupCode(String group_code) {
            this.group_code = group_code;
        }

        /**
         * @return The phase
         */
        @JsonProperty("phase")
        public String getPhase() {
            return phase;
        }

        /**
         * @param phase The phase
         */
        @JsonProperty("phase")
        public void setPhase(String phase) {
            this.phase = phase;
        }

        /**
         * @return The playoff
         */
        @JsonProperty("playoff")
        public String getPlayoff() {
            return playoff;
        }

        /**
         * @param playoff The playoff
         */
        @JsonProperty("playoff")
        public void setPlayoff(String playoff) {
            this.playoff = playoff;
        }

        /**
         * @return The totalRounds
         */
        @JsonProperty("total_rounds")
        public Integer getTotalRounds() {
            return total_rounds;
        }

        /**
         * @param totalRounds The total_rounds
         */
        @JsonProperty("total_rounds")
        public void setTotalRounds(Integer total_rounds) {
            this.total_rounds = total_rounds;
        }

        /**
         * @return The year
         */
        @JsonProperty("year")
        public Integer getYear() {
            return year;
        }

        /**
         * @param year The year
         */
        @JsonProperty("year")
        public void setYear(Integer year) {
            this.year = year;
        }

        /**
         * @return The countryId
         */
        @JsonProperty("country_id")
        public Integer getCountryId() {
            return country_id;
        }

        /**
         * @param countryId The country_id
         */
        @JsonProperty("country_id")
        public void setCountryId(Integer country_id) {
            this.country_id = country_id;
        }

        /**
         * @return The active
         */
        @JsonProperty("active")
        public Boolean getActive() {
            return active;
        }

        /**
         * @param active The active
         */
        @JsonProperty("active")
        public void setActive(Boolean active) {
            this.active = active;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "iddaa"
    })
    public class Odds {

        @JsonProperty("iddaa")
        private Iddaa iddaa;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The iddaa
         */
        @JsonProperty("iddaa")
        public Iddaa getIddaa() {
            return iddaa;
        }

        /**
         * @param iddaa The iddaa
         */
        @JsonProperty("iddaa")
        public void setIddaa(Iddaa iddaa) {
            this.iddaa = iddaa;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "name",
            "image",
            "yearBuilt",
            "seats"
    })
    public class Stadium {

        @JsonProperty("name")
        private Object name;
        @JsonProperty("image")
        private Object image;
        @JsonProperty("yearBuilt")
        private Object yearBuilt;
        @JsonProperty("seats")
        private Object seats;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The name
         */
        @JsonProperty("name")
        public Object getName() {
            return name;
        }

        /**
         * @param name The name
         */
        @JsonProperty("name")
        public void setName(Object name) {
            this.name = name;
        }

        /**
         * @return The image
         */
        @JsonProperty("image")
        public Object getImage() {
            return image;
        }

        /**
         * @param image The image
         */
        @JsonProperty("image")
        public void setImage(Object image) {
            this.image = image;
        }

        /**
         * @return The yearBuilt
         */
        @JsonProperty("yearBuilt")
        public Object getYearBuilt() {
            return yearBuilt;
        }

        /**
         * @param yearBuilt The yearBuilt
         */
        @JsonProperty("yearBuilt")
        public void setYearBuilt(Object yearBuilt) {
            this.yearBuilt = yearBuilt;
        }

        /**
         * @return The seats
         */
        @JsonProperty("seats")
        public Object getSeats() {
            return seats;
        }

        /**
         * @param seats The seats
         */
        @JsonProperty("seats")
        public void setSeats(Object seats) {
            this.seats = seats;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "name",
            "image",
            "yearBuilt",
            "seats"
    })
    public class Stadium_ {

        @JsonProperty("name")
        private Object name;
        @JsonProperty("image")
        private Object image;
        @JsonProperty("yearBuilt")
        private Object yearBuilt;
        @JsonProperty("seats")
        private Object seats;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The name
         */
        @JsonProperty("name")
        public Object getName() {
            return name;
        }

        /**
         * @param name The name
         */
        @JsonProperty("name")
        public void setName(Object name) {
            this.name = name;
        }

        /**
         * @return The image
         */
        @JsonProperty("image")
        public Object getImage() {
            return image;
        }

        /**
         * @param image The image
         */
        @JsonProperty("image")
        public void setImage(Object image) {
            this.image = image;
        }

        /**
         * @return The yearBuilt
         */
        @JsonProperty("yearBuilt")
        public Object getYearBuilt() {
            return yearBuilt;
        }

        /**
         * @param yearBuilt The yearBuilt
         */
        @JsonProperty("yearBuilt")
        public void setYearBuilt(Object yearBuilt) {
            this.yearBuilt = yearBuilt;
        }

        /**
         * @return The seats
         */
        @JsonProperty("seats")
        public Object getSeats() {
            return seats;
        }

        /**
         * @param seats The seats
         */
        @JsonProperty("seats")
        public void setSeats(Object seats) {
            this.seats = seats;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "away",
            "home"
    })
    public class Analysis {

        @JsonProperty("away")
        private String away;
        @JsonProperty("home")
        private String home;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The away
         */
        @JsonProperty("away")
        public String getAway() {
            return away;
        }

        /**
         * @param away The away
         */
        @JsonProperty("away")
        public void setAway(String away) {
            this.away = away;
        }

        /**
         * @return The home
         */
        @JsonProperty("home")
        public String getHome() {
            return home;
        }

        /**
         * @param home The home
         */
        @JsonProperty("home")
        public void setHome(String home) {
            this.home = home;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "team_name",
            "team_name_tr",
            "resultados_id",
            "stadium",
            "color1",
            "color2",
            "team_logos",
            "seo_name"
    })
    public class AwayTeam {

        @JsonProperty("id")
        private String id;
        @JsonProperty("team_name")
        private String team_name;
        @JsonProperty("team_name_tr")
        private String team_name_tr;
        @JsonProperty("resultados_id")
        private Integer resultados_id;
        @JsonProperty("stadium")
        private Stadium_ stadium;
        @JsonProperty("color1")
        private String color1;
        @JsonProperty("color2")
        private String color2;
        @JsonProperty("team_logos")
        private List<String> team_logos = new ArrayList<String>();
        @JsonProperty("seo_name")
        private String seo_name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The teamName
         */
        @JsonProperty("team_name")
        public String getTeamName() {
            return team_name;
        }

        /**
         * @param teamName The team_name
         */
        @JsonProperty("team_name")
        public void setTeamName(String team_name) {
            this.team_name = team_name;
        }

        /**
         * @return The teamNameTr
         */
        @JsonProperty("team_name_tr")
        public String getTeamNameTr() {
            return team_name_tr;
        }

        /**
         * @param teamNameTr The team_name_tr
         */
        @JsonProperty("team_name_tr")
        public void setTeamNameTr(String team_name_tr) {
            this.team_name_tr = team_name_tr;
        }

        /**
         * @return The resultadosId
         */
        @JsonProperty("resultados_id")
        public Integer getResultadosId() {
            return resultados_id;
        }

        /**
         * @param resultadosId The resultados_id
         */
        @JsonProperty("resultados_id")
        public void setResultadosId(Integer resultados_id) {
            this.resultados_id = resultados_id;
        }

        /**
         * @return The stadium
         */
        @JsonProperty("stadium")
        public Stadium_ getStadium() {
            return stadium;
        }

        /**
         * @param stadium The stadium
         */
        @JsonProperty("stadium")
        public void setStadium(Stadium_ stadium) {
            this.stadium = stadium;
        }

        /**
         * @return The color1
         */
        @JsonProperty("color1")
        public String getColor1() {
            return color1;
        }

        /**
         * @param color1 The color1
         */
        @JsonProperty("color1")
        public void setColor1(String color1) {
            this.color1 = color1;
        }

        /**
         * @return The color2
         */
        @JsonProperty("color2")
        public String getColor2() {
            return color2;
        }

        /**
         * @param color2 The color2
         */
        @JsonProperty("color2")
        public void setColor2(String color2) {
            this.color2 = color2;
        }

        /**
         * @return The teamLogos
         */
        @JsonProperty("team_logos")
        public List<String> getTeamLogos() {
            return team_logos;
        }

        /**
         * @param teamLogos The team_logos
         */
        @JsonProperty("team_logos")
        public void setTeamLogos(List<String> team_logos) {
            this.team_logos = team_logos;
        }

        /**
         * @return The seoName
         */
        @JsonProperty("seo_name")
        public String getSeoName() {
            return seo_name;
        }

        /**
         * @param seoName The seo_name
         */
        @JsonProperty("seo_name")
        public void setSeoName(String seo_name) {
            this.seo_name = seo_name;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonPropertyOrder({
            "id",
            "country_name_tr",
            "country_name",
            "country_code",
            "order",
            "seo_name"
    })
    public class Country {

        @JsonProperty("id")
        private String id;
        @JsonProperty("country_name_tr")
        private String country_name_tr;
        @JsonProperty("country_name")
        private String country_name;
        @JsonProperty("country_code")
        private String country_code;
        @JsonProperty("order")
        private Integer order;
        @JsonProperty("seo_name")
        private String seo_name;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        @JsonProperty("id")
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The countryNameTr
         */
        @JsonProperty("country_name_tr")
        public String getCountryNameTr() {
            return country_name_tr;
        }

        /**
         * @param countryNameTr The country_name_tr
         */
        @JsonProperty("country_name_tr")
        public void setCountryNameTr(String country_name_tr) {
            this.country_name_tr = country_name_tr;
        }

        /**
         * @return The countryName
         */
        @JsonProperty("country_name")
        public String getCountryName() {
            return country_name;
        }

        /**
         * @param countryName The country_name
         */
        @JsonProperty("country_name")
        public void setCountryName(String country_name) {
            this.country_name = country_name;
        }

        /**
         * @return The countryCode
         */
        @JsonProperty("country_code")
        public String getCountryCode() {
            return country_code;
        }

        /**
         * @param countryCode The country_code
         */
        @JsonProperty("country_code")
        public void setCountryCode(String country_code) {
            this.country_code = country_code;
        }

        /**
         * @return The order
         */
        @JsonProperty("order")
        public Integer getOrder() {
            return order;
        }

        /**
         * @param order The order
         */
        @JsonProperty("order")
        public void setOrder(Integer order) {
            this.order = order;
        }

        /**
         * @return The seoName
         */
        @JsonProperty("seo_name")
        public String getSeoName() {
            return seo_name;
        }

        /**
         * @param seoName The seo_name
         */
        @JsonProperty("seo_name")
        public void setSeoName(String seo_name) {
            this.seo_name = seo_name;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

}


