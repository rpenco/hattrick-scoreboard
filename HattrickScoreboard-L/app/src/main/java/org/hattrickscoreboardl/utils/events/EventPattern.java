package org.hattrickscoreboardl.utils.events;

import android.text.Html;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by romain
 * on 06/12/2014.
 */
public class EventPattern {

//    private static String TAGPLAYERPATTERN = "class=\"(.+?)\"";

    public static List<EventPlayer> getPlayers(String text) {

        List<EventPlayer> players = new ArrayList<EventPlayer>();

        List<String> matcherID = getEventTag(text, "playerId=(.+?)\"");
        List<String> matcherName = getEventTag(text, "title=\"(.+?)\"");

        if(matcherID.size() == matcherName.size()){
            for (int i = 0; i < matcherID.size(); i++) {
                int id = Integer.parseInt(matcherID.get(i));
                String name = matcherName.get(i);
                players.add(new EventPlayer(Html.fromHtml(name).toString(), id));
            }
        }else{
            Log.e("EventPattern","Text error.");
            Log.e("EventPattern",text);
        }
        return players;
    }

    public static String cleanEventText(String text){
        return Html.fromHtml(text).toString();
    }

    static List<String> getEventTag(String str, String pattern) {
        List<String> tagValues = new ArrayList<String>();
        Pattern patt = Pattern.compile(pattern);
        Matcher matcher = patt.matcher(str);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }

/*
    <SubjectPlayerID>323855218</SubjectPlayerID>
    <SubjectTeamID>529163</SubjectTeamID>
    <ObjectPlayerID>370060958</ObjectPlayerID>

    La foule fut amusée de voir
    <a href="/Club/Players/Player.aspx?playerId=370060958" title="Davide Pogliani" class="homeplayer">Davide Pogliani</a>
    de <span class="hometeam">Kangaroos</span> réussir quelques feintes et autres dribbles
    pour parvenir jusqu'à la surface de réparation adverse.
    Le tir de son coéquipier <a href="/Club/Players/Player.aspx?playerId=323855218" title="Peter Kienast" class="homeplayer">Peter Kienast</a>,
    qui récupéra le ballon à la suite de cette action, fut bien moins amusant en revanche.

<a href="/Club/Players/Player.aspx?playerId=297262482" title="Michał Eichstaedt" class="homeplayer">Michał Eichstaedt</a> marqua sur coup franc après 82 minutes : 5 - 2 pour <span class="hometeam">Thule SK</span>.

    <a href="/Club/Players/Player.aspx?playerId=397226303" title="Dan Munteanu" class="awayplayer">Dan Munteanu</a> récupéra un ballon sur la gauche après 11 minutes de jeu et tenta sa chance de loin, mais le ballon passa largement à côté.

<?xml version="1.0" encoding="utf-8"?>
<HattrickData>
  <FileName>live.xml</FileName>
  <Version>1.8</Version>
  <UserID>4593312</UserID>
  <FetchedDate>2014-12-06 11:33:40</FetchedDate>
  <MatchList>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5593550</MatchID>
      <MatchDate>2014-12-05 21:40:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>529163</HomeTeamID>
        <HomeTeamName>The Water Kangaroos</HomeTeamName>
        <HomeTeamShortName>Kangaroos</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>36415</AwayTeamID>
        <AwayTeamName>Amatorii din CT</AwayTeamName>
        <AwayTeamShortName>AdCT</AwayTeamShortName>
      </AwayTeam>
      <EventList>
        <Event Index="0">
          <Minute>0</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>1030502</ObjectPlayerID>
          <EventKey>20_5</EventKey>
          <EventText>Pour cette rencontre, l’entraineur de <span class="hometeam">Kangaroos</span> sortit un 3-5-2 de son chapeau. Est-ce que ce schéma tactique portera ses fruits ?</EventText>
        </Event>
        <Event Index="4">
          <Minute>1</Minute>
          <SubjectPlayerID>154</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>334_3</EventKey>
          <EventText>Il était évident que <span class="awayteam">AdCT</span> avait décidé d'attaquer sur les ailes.</EventText>
        </Event>
        <Event Index="5">
          <Minute>11</Minute>
          <SubjectPlayerID>397226303</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>402229533</ObjectPlayerID>
          <EventKey>272_3</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=397226303" title="Dan Munteanu" class="awayplayer">Dan Munteanu</a> récupéra un ballon sur la gauche après 11 minutes de jeu et tenta sa chance de loin, mais le ballon passa largement à côté.</EventText>
        </Event>
        <Event Index="6">
          <Minute>42</Minute>
          <SubjectPlayerID>323855218</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>370060958</ObjectPlayerID>
          <EventKey>208_1</EventKey>
          <EventText>La foule fut amusée de voir <a href="/Club/Players/Player.aspx?playerId=370060958" title="Davide Pogliani" class="homeplayer">Davide Pogliani</a> de <span class="hometeam">Kangaroos</span> réussir quelques feintes et autres dribbles pour parvenir jusqu'à la surface de réparation adverse. Le tir de son coéquipier <a href="/Club/Players/Player.aspx?playerId=323855218" title="Peter Kienast" class="homeplayer">Peter Kienast</a>, qui récupéra le ballon à la suite de cette action, fut bien moins amusant en revanche.</EventText>
        </Event>
        <Event Index="7">
          <Minute>43</Minute>
          <SubjectPlayerID>390313124</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>402229533</ObjectPlayerID>
          <EventKey>172_3</EventKey>
          <EventText>Après 43 minutes de jeu, <span class="awayteam">AdCT</span> porta le score à 0 - 1. <a href="/Club/Players/Player.aspx?playerId=390313124" title="Bj&amp;#248;rnar Borgen" class="awayplayer">Bjørnar Borgen</a>, après avoir effacé deux joueurs sur le côté gauche du terrain, frappa le ballon avec une telle puissance que le gardien n'esquissa pas le moindre geste.</EventText>
        </Event>
        <Event Index="8">
          <Minute>44</Minute>
          <SubjectPlayerID>90</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>61_1</EventKey>
          <EventText>44 minutes s’étaient écoulées et <span class="hometeam">Kangaroos</span> avait du mal à trouver ses marques ; le degré d’organisation de l’équipe chuta à <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=6#skill" class="skill">passable</a>.</EventText>
        </Event>
        <Event Index="11">
          <Minute>44</Minute>
          <SubjectPlayerID>397226303</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>402229533</ObjectPlayerID>
          <EventKey>182_4</EventKey>
          <EventText>Une attaque éclair sur le côté gauche après 44 minutes permit à <a href="/Club/Players/Player.aspx?playerId=397226303" title="Dan Munteanu" class="awayplayer">Dan Munteanu</a> d’inscrire un nouveau but pour <span class="awayteam">AdCT</span>, qui menait désormais 0 - 3.</EventText>
        </Event>
        <Event Index="12">
          <Minute>45</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>0</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>45_1</EventKey>
          <EventText>Le score à la mi-temps était de 0 - 3.</EventText>
        </Event>
        <Event Index="14">
          <Minute>46</Minute>
          <SubjectPlayerID>402229532</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>97</ObjectPlayerID>
          <EventKey>64_5</EventKey>
          <EventText>L’entraineur de <span class="hometeam">Kangaroos</span> passa un peu de temps à redonner des consignes tactiques pendant la pause, ce qui permit aux joueurs de retrouver un niveau d’organisation <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=7#skill" class="skill">honorable</a>.</EventText>
        </Event>
        <Event Index="15">
          <Minute>55</Minute>
          <SubjectPlayerID>357356450</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>402229533</ObjectPlayerID>
          <EventKey>282_3</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=357356450" title="Sebastian Poggiali" class="awayplayer">Sebastian Poggiali</a> de <span class="awayteam">AdCT</span> fournissait un bon travail sur l’aile gauche depuis le début du match et, après 55 minutes de jeu, cela aurait pu payer mais le gardien bloqua son tir.</EventText>
        </Event>
        <Event Index="16">
          <Minute>68</Minute>
          <SubjectPlayerID>94</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>61_2</EventKey>
          <EventText>68 minutes s’étaient écoulées et <span class="hometeam">Kangaroos</span> semblait souffrir d’une certaine confusion. Au bout d’un moment, le degré d’organisation de l’équipe n’était plus que <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=6#skill" class="skill">passable</a>.</EventText>
        </Event>
        <Event Index="17">
          <Minute>86</Minute>
          <SubjectPlayerID>89</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>61_4</EventKey>
          <EventText>Après 86 minutes, la confusion régnait sur le terrain à cause de la formation utilisée. Les joueurs de <span class="hometeam">Kangaroos</span> n’étaient pas tous à leur place et le degré d’organisation de l’équipe devint rapidement <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=5#skill" class="skill">inadéquat</a>.</EventText>
        </Event>
        <Event Index="18">
          <Minute>88</Minute>
          <SubjectPlayerID>390313124</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>510_4</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=390313124" title="Bj&amp;#248;rnar Borgen" class="awayplayer">Bjørnar Borgen</a> de <span class="awayteam">AdCT</span> reçut un carton jaune après 88 minutes pour avoir fauché un joueur de l’équipe adverse.</EventText>
        </Event>
        <Event Index="20">
          <Minute>89</Minute>
          <SubjectPlayerID>260324946</SubjectPlayerID>
          <SubjectTeamID>529163</SubjectTeamID>
          <ObjectPlayerID>397715143</ObjectPlayerID>
          <EventKey>240_2</EventKey>
          <EventText><span class="hometeam">Kangaroos</span> était sous pression, mais réussissait tout de même de bons contres, et sur l’un d’eux, après 89 minutes, <a href="/Club/Players/Player.aspx?playerId=260324946" title="Topi Nokelainen" class="homeplayer">Topi Nokelainen</a> obtint un bon coup franc mais manqua de peu le cadre.</EventText>
        </Event>
        <Event Index="21">
          <Minute>90</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>36415</SubjectTeamID>
          <ObjectPlayerID>60</ObjectPlayerID>
          <EventKey>40_2</EventKey>
          <EventText><span class="awayteam">AdCT</span> monopolisait le ballon, avec 60 % de possession.<br /><br /></EventText>
        </Event>
        <Event Index="28">
          <Minute>90</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>0</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>599_3</EventKey>
          <EventText>Le match se termina sur le score de 1 - 3.</EventText>
        </Event>
      </EventList>
      <HomeGoals>1</HomeGoals>
      <AwayGoals>3</AwayGoals>
      <LastShownEventIndex>28</LastShownEventIndex>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5594696</MatchID>
      <MatchDate>2014-12-06 10:58:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>301711</HomeTeamID>
        <HomeTeamName>Thule Sportklub</HomeTeamName>
        <HomeTeamShortName>Thule SK</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>1025457</AwayTeamID>
        <AwayTeamName>de joekes</AwayTeamName>
        <AwayTeamShortName>joekes</AwayTeamShortName>
      </AwayTeam>
      <EventList>
        <Event Index="0">
          <Minute>0</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>301711</SubjectTeamID>
          <ObjectPlayerID>1020503</ObjectPlayerID>
          <EventKey>20_4</EventKey>
          <EventText><span class="hometeam">Thule SK</span> décida de jouer en 2-5-3.</EventText>
        </Event>
        <Event Index="4">
          <Minute>1</Minute>
          <SubjectPlayerID>326</SubjectPlayerID>
          <SubjectTeamID>1025457</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>334_2</EventKey>
          <EventText><span class="awayteam">joekes</span> avait décidé d'attaquer sur les ailes, c'est pourquoi la plupart de leurs passes se dirigeaient vers les côtés du terrain.</EventText>
        </Event>
        <Event Index="5">
          <Minute>4</Minute>
          <SubjectPlayerID>310386899</SubjectPlayerID>
          <SubjectTeamID>301711</SubjectTeamID>
          <ObjectPlayerID>248766485</ObjectPlayerID>
          <EventKey>222_4</EventKey>
          <EventText>Un relâchement de la défense adverse donna à <span class="hometeam">Thule SK</span> l’occasion de récupérer le ballon après 4 minutes et de porter le danger sur l’aile gauche. Mais, d’un tir maladroit facilement stoppé par le gardien adverse, <a href="/Club/Players/Player.aspx?playerId=310386899" title="Elaman Ibray" class="homeplayer">Elaman Ibray</a> gâcha cette belle occasion de mener au score.</EventText>
        </Event>
        <Event Index="6">
          <Minute>33</Minute>
          <SubjectPlayerID>310386899</SubjectPlayerID>
          <SubjectTeamID>301711</SubjectTeamID>
          <ObjectPlayerID>248766485</ObjectPlayerID>
          <EventKey>122_3</EventKey>
          <EventText>Le match se jouait depuis 33 minutes lorsque l’équipe locale prit l’avantage, 1 à 0, après une erreur du flanc droit de la défense adverse. Le buteur de <span class="hometeam">Thule SK</span> fut <a href="/Club/Players/Player.aspx?playerId=310386899" title="Elaman Ibray" class="homeplayer">Elaman Ibray</a>.</EventText>
        </Event>
        <Event Index="7">
          <Minute>34</Minute>
          <SubjectPlayerID>306181428</SubjectPlayerID>
          <SubjectTeamID>1025457</SubjectTeamID>
          <ObjectPlayerID>315036863</ObjectPlayerID>
          <EventKey>262_1</EventKey>
          <EventText>L’égalisation semblait acquise pour les visiteurs après 34 minutes sur cette action menée sur le côté gauche, mais <a href="/Club/Players/Player.aspx?playerId=315036863" title="Florian Karner" class="homeplayer">Florian Karner</a> réussit à gagner son duel face à <a href="/Club/Players/Player.aspx?playerId=306181428" title="Vitali Tughushi" class="awayplayer">Vitali Tughushi</a>. Pas de but.</EventText>
        </Event>
      </EventList>
      <HomeGoals>1</HomeGoals>
      <AwayGoals>0</AwayGoals>
      <LastShownEventIndex>7</LastShownEventIndex>
      <NextEventMinute>42</NextEventMinute>
    </Match>
    <Match>
      <SourceSystem>Hattrick</SourceSystem>
      <MatchID>501419525</MatchID>
      <MatchDate>2014-12-06 14:00:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>490221</HomeTeamID>
        <HomeTeamName>lisergicos united</HomeTeamName>
        <HomeTeamShortName>lisergicos</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>795149</AwayTeamID>
        <AwayTeamName>CAÑITA BRAVA</AwayTeamName>
        <AwayTeamShortName>CAÑITA</AwayTeamShortName>
      </AwayTeam>
      <EventList />
      <HomeGoals>0</HomeGoals>
      <AwayGoals>0</AwayGoals>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5595075</MatchID>
      <MatchDate>2014-12-06 13:17:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>507772</HomeTeamID>
        <HomeTeamName>Aruba Falcons</HomeTeamName>
        <HomeTeamShortName>Falcons</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>556652</AwayTeamID>
        <AwayTeamName>The Treasury</AwayTeamName>
        <AwayTeamShortName>Treasury</AwayTeamShortName>
      </AwayTeam>
      <EventList />
      <HomeGoals>0</HomeGoals>
      <AwayGoals>0</AwayGoals>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5594570</MatchID>
      <MatchDate>2014-12-06 09:58:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>1004888</HomeTeamID>
        <HomeTeamName>FC Tojans</HomeTeamName>
        <HomeTeamShortName>Tojans</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>455293</AwayTeamID>
        <AwayTeamName>Guld jägarna</AwayTeamName>
        <AwayTeamShortName>jägarna</AwayTeamShortName>
      </AwayTeam>
      <EventList>
        <Event Index="0">
          <Minute>0</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>1030502</ObjectPlayerID>
          <EventKey>20_2</EventKey>
          <EventText><span class="hometeam">Tojans</span> choisit une formation stratégique, un 3-5-2.</EventText>
        </Event>
        <Event Index="4">
          <Minute>18</Minute>
          <SubjectPlayerID>390329676</SubjectPlayerID>
          <SubjectTeamID>455293</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>303_5</EventKey>
          <EventText>Ce temps ensoleillé était idéal pour <a href="/Club/Players/Player.aspx?playerId=390329676" title="N&amp;#233;stor Rolando Augusto" class="awayplayer">Néstor Rolando Augusto</a>, qui ridiculisa plusieurs fois ses adversaires par quelques superbes gestes techniques.</EventText>
        </Event>
        <Event Index="5">
          <Minute>22</Minute>
          <SubjectPlayerID>391910480</SubjectPlayerID>
          <SubjectTeamID>455293</SubjectTeamID>
          <ObjectPlayerID>392108651</ObjectPlayerID>
          <EventKey>141_1</EventKey>
          <EventText><span class="awayteam">jägarna</span> réussissait à bien contre-attaquer et après 22 minutes de jeu, <a href="/Club/Players/Player.aspx?playerId=391910480" title="Fredrik Christiansson" class="awayplayer">Fredrik Christiansson</a> s'engouffra dans la défense centrale après une belle action, portant ainsi le score à 0 - 1.</EventText>
        </Event>
        <Event Index="6">
          <Minute>26</Minute>
          <SubjectPlayerID>89</SubjectPlayerID>
          <SubjectTeamID>455293</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>61_5</EventKey>
          <EventText>26 minutes s’étaient écoulées et le jeu de <span class="awayteam">jägarna</span> semblait un peu hésitant. Son degré d’organisation chuta à <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=5#skill" class="skill">inadéquat</a>.</EventText>
        </Event>
        <Event Index="7">
          <Minute>31</Minute>
          <SubjectPlayerID>360625656</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>111_4</EventKey>
          <EventText>Après 31 minutes de jeu, <a href="/Club/Players/Player.aspx?playerId=360625656" title="Harald Talberger" class="homeplayer">Harald Talberger</a> remit les deux équipes à égalité grâce à un superbe but après une action au centre du terrain. 1 - 1.</EventText>
        </Event>
        <Event Index="8">
          <Minute>37</Minute>
          <SubjectPlayerID>381904417</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>223_4</EventKey>
          <EventText>Après 37 minutes de jeu, <span class="hometeam">Tojans</span> aurait pu prendre l’avantage si <a href="/Club/Players/Player.aspx?playerId=381904417" title="Piotr Cienki" class="homeplayer">Piotr Cienki</a> avait mieux ajusté sa reprise de volée sur un centre venant de la droite.</EventText>
        </Event>
        <Event Index="9">
          <Minute>45</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>0</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>45_5</EventKey>
          <EventText>1 - 1 était le score à la mi-temps.</EventText>
        </Event>
        <Event Index="11">
          <Minute>46</Minute>
          <SubjectPlayerID>391695599</SubjectPlayerID>
          <SubjectTeamID>455293</SubjectTeamID>
          <ObjectPlayerID>97</ObjectPlayerID>
          <EventKey>64_4</EventKey>
          <EventText>À la pause, l’entraineur de <span class="awayteam">jägarna</span> donna une nouvelle fois quelques consignes tactiques à ses joueurs. Leur niveau d’organisation remonta ainsi à <a href="/Help/Rules/AppDenominations.aspx?lt=skill&amp;amp;ll=7#skill" class="skill">honorable</a>.</EventText>
        </Event>
        <Event Index="12">
          <Minute>59</Minute>
          <SubjectPlayerID>356392402</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>123_3</EventKey>
          <EventText>L’équipe locale réussit à prendre l’avantage par 2 à 1 après 59 minutes, grâce à un magnifique mouvement de <a href="/Club/Players/Player.aspx?playerId=356392402" title="Tristan Leclercq" class="homeplayer">Tristan Leclercq</a> sur l’aile droite.</EventText>
        </Event>
        <Event Index="13">
          <Minute>67</Minute>
          <SubjectPlayerID>356392402</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>131_4</EventKey>
          <EventText>Des cris de joie résonnèrent dans le stade au moment où <a href="/Club/Players/Player.aspx?playerId=356392402" title="Tristan Leclercq" class="homeplayer">Tristan Leclercq</a> franchit la défense centrale adverse pour inscrire le but du 3 - 1 pour <span class="hometeam">Tojans</span>.</EventText>
        </Event>
        <Event Index="14">
          <Minute>69</Minute>
          <SubjectPlayerID>388968383</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>349433589</ObjectPlayerID>
          <EventKey>119_5</EventKey>
          <EventText>Et pan ! On l’attendait. Il fut pour <a href="/Club/Players/Player.aspx?playerId=349433589" title="Horst-Ulrich Atzenhain" class="homeplayer">Horst-Ulrich Atzenhain</a> du pied et du coin, et surtout pour <a href="/Club/Players/Player.aspx?playerId=388968383" title="Abuzer Torlak" class="homeplayer">Abuzer Torlak</a> qui reprit le ballon de la tête. Elle n’eut plus d'autre choix que de trouer le filet ! 4 - 1 au tableau d’affichage après 69 minutes.</EventText>
        </Event>
        <Event Index="15">
          <Minute>73</Minute>
          <SubjectPlayerID>349433589</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>134_5</EventKey>
          <EventText>Sur pénalty, <a href="/Club/Players/Player.aspx?playerId=349433589" title="Horst-Ulrich Atzenhain" class="homeplayer">Horst-Ulrich Atzenhain</a> de <span class="hometeam">Tojans</span> prit le gardien adverse à contre-pied, permettant ainsi d’augmenter l’avance de son équipe à 5 - 1 au bout de 73 minutes.</EventText>
        </Event>
        <Event Index="16">
          <Minute>74</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>62_5</EventKey>
          <EventText>Les joueurs de <span class="hometeam">Tojans</span> semblèrent penser que leur travail était terminé et axèrent davantage leur jeu sur la défense, dans l’attente du coup de sifflet final.</EventText>
        </Event>
        <Event Index="17">
          <Minute>76</Minute>
          <SubjectPlayerID>349433589</SubjectPlayerID>
          <SubjectTeamID>1004888</SubjectTeamID>
          <ObjectPlayerID>400726402</ObjectPlayerID>
          <EventKey>233_2</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=349433589" title="Horst-Ulrich Atzenhain" class="homeplayer">Horst-Ulrich Atzenhain</a> manqua de peu de marquer un nouveau but pour <span class="hometeam">Tojans</span>, lorsque sa reprise de la tête sur un centre venant de la droite fut détournée par le gardien.</EventText>
        </Event>
      </EventList>
      <HomeGoals>5</HomeGoals>
      <AwayGoals>1</AwayGoals>
      <LastShownEventIndex>17</LastShownEventIndex>
      <NextEventMinute>83</NextEventMinute>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5594633</MatchID>
      <MatchDate>2014-12-06 10:35:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>987080</HomeTeamID>
        <HomeTeamName>Bloody Cookers</HomeTeamName>
        <HomeTeamShortName>Cookers</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>1132750</AwayTeamID>
        <AwayTeamName>Tomtens AK</AwayTeamName>
        <AwayTeamShortName>Tomtens</AwayTeamShortName>
      </AwayTeam>
      <EventList>
        <Event Index="0">
          <Minute>0</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>1030502</ObjectPlayerID>
          <EventKey>20_4</EventKey>
          <EventText><span class="hometeam">Cookers</span> décida de jouer en 3-5-2.</EventText>
        </Event>
        <Event Index="4">
          <Minute>1</Minute>
          <SubjectPlayerID>163</SubjectPlayerID>
          <SubjectTeamID>1132750</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>334_2</EventKey>
          <EventText><span class="awayteam">Tomtens</span> avait décidé d'attaquer sur les ailes, c'est pourquoi la plupart de leurs passes se dirigeaient vers les côtés du terrain.</EventText>
        </Event>
        <Event Index="5">
          <Minute>11</Minute>
          <SubjectPlayerID>221400690</SubjectPlayerID>
          <SubjectTeamID>1132750</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>301_5</EventKey>
          <EventText>La pluie rendait le jeu difficile pour des joueurs comme <a href="/Club/Players/Player.aspx?playerId=221400690" title="Iacopo Reggiani" class="awayplayer">Iacopo Reggiani</a>, dont les contrôles de balle étaient beaucoup moins techniques qu’à l’accoutumée.</EventText>
        </Event>
        <Event Index="6">
          <Minute>19</Minute>
          <SubjectPlayerID>292595393</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>395602597</ObjectPlayerID>
          <EventKey>121_3</EventKey>
          <EventText><span class="hometeam">Cookers</span> prit la tête au bout de 19 minutes de jeu par 1 à 0, à la suite d’une belle action au centre du terrain, qui se termina par une passe en profondeur que <a href="/Club/Players/Player.aspx?playerId=292595393" title="Joan Antoni Donada" class="homeplayer">Joan Antoni Donada</a> réussit à reprendre du bout du pied.</EventText>
        </Event>
        <Event Index="7">
          <Minute>24</Minute>
          <SubjectPlayerID>370421211</SubjectPlayerID>
          <SubjectTeamID>1132750</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>511_5</EventKey>
          <EventText>Après 24 minutes, <a href="/Club/Players/Player.aspx?playerId=370421211" title="Alfons Stranimeier-Seifert" class="awayplayer">Alfons Stranimeier-Seifert</a> de <span class="awayteam">Tomtens</span> reçut un carton jaune pour s’être emparé du ballon afin d’empêcher l’équipe adverse de jouer rapidement un coup franc.</EventText>
        </Event>
        <Event Index="8">
          <Minute>25</Minute>
          <SubjectPlayerID>336400359</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>511_2</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=336400359" title="Maxim Tentrus" class="homeplayer">Maxim Tentrus</a> de <span class="hometeam">Cookers</span> reçut un carton jaune après 25 minutes de jeu pour comportement anti-sportif.</EventText>
        </Event>
        <Event Index="9">
          <Minute>28</Minute>
          <SubjectPlayerID>297736995</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>395602597</ObjectPlayerID>
          <EventKey>185_2</EventKey>
          <EventText>Vu l’angle fermé offert par ce coup franc, <span class="hometeam">Cookers</span> opta pour une combinaison que les plus fidèles supporters auront reconnue à l’entrainement. Un enchainement de passes décala la défense et <a href="/Club/Players/Player.aspx?playerId=297736995" title="Aron Sordam" class="homeplayer">Aron Sordam</a> n’avait plus qu’à glisser le ballon dans les buts. 2 - 0 après 28 minutes de jeu.</EventText>
        </Event>
        <Event Index="10">
          <Minute>29</Minute>
          <SubjectPlayerID>307712855</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>395602597</ObjectPlayerID>
          <EventKey>185_4</EventKey>
          <EventText>Après 29 minutes de jeu, vu la position difficile du coup franc, <span class="hometeam">Cookers</span> ne se décida pas pour un tir direct mais visa plutôt la zone juste devant le gardien. Les attaquants étaient bien synchronisés et rendaient difficile la défense des cages. Après s’être démené comme un beau diable, <a href="/Club/Players/Player.aspx?playerId=307712855" title="Viktor Piel" class="homeplayer">Viktor Piel</a> réussit à glisser le ballon derrière le gardien. 3 - 0.</EventText>
        </Event>
        <Event Index="12">
          <Minute>30</Minute>
          <SubjectPlayerID>270949702</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>395602597</ObjectPlayerID>
          <EventKey>131_5</EventKey>
          <EventText><span class="hometeam">Cookers</span> consolida son avance après 30 minutes lorsque <a href="/Club/Players/Player.aspx?playerId=270949702" title="Elimane 'Le bouledogue' A&amp;#239;dara" class="homeplayer">Elimane 'Le bouledogue' Aïdara</a> réussit à se jouer de la défense centrale pour marquer le but du 4 - 0.</EventText>
        </Event>
        <Event Index="13">
          <Minute>31</Minute>
          <SubjectPlayerID>302689564</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>395602597</ObjectPlayerID>
          <EventKey>131_2</EventKey>
          <EventText>Après 31 minutes de jeu, la défense centrale fut prise de vitesse par <a href="/Club/Players/Player.aspx?playerId=302689564" title="Assad 'Le lion' Hisham" class="homeplayer">Assad 'Le lion' Hisham</a>, qui put ensuite lober le gardien. Le score était maintenant de 5 - 0 pour <span class="hometeam">Cookers</span>.</EventText>
        </Event>
        <Event Index="14">
          <Minute>32</Minute>
          <SubjectPlayerID>297736995</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>242410416</ObjectPlayerID>
          <EventKey>138_2</EventKey>
          <EventText><a href="/Club/Players/Player.aspx?playerId=242410416" title="Bamba 'La foudre' Tandian" class="homeplayer">Bamba 'La foudre' Tandian</a> de <span class="hometeam">Cookers</span> dominait son aile et réussissait à faire quelques bons centres ; sur l’un d’eux, <a href="/Club/Players/Player.aspx?playerId=297736995" title="Aron Sordam" class="homeplayer">Aron Sordam</a> trouva le cadre. 6 - 0 après 32 minutes.</EventText>
        </Event>
        <Event Index="15">
          <Minute>34</Minute>
          <SubjectPlayerID>307712855</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>511_1</EventKey>
          <EventText>Après plusieurs tirages de maillot évidents, <a href="/Club/Players/Player.aspx?playerId=307712855" title="Viktor Piel" class="homeplayer">Viktor Piel</a> de <span class="hometeam">Cookers</span> reçut un avertissement.</EventText>
        </Event>
        <Event Index="16">
          <Minute>45</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>0</SubjectTeamID>
          <ObjectPlayerID>0</ObjectPlayerID>
          <EventKey>45_2</EventKey>
          <EventText>Les deux équipes rentrèrent aux vestiaires sur le score de 6 - 0.</EventText>
        </Event>
        <Event Index="17">
          <Minute>45</Minute>
          <SubjectPlayerID>0</SubjectPlayerID>
          <SubjectTeamID>987080</SubjectTeamID>
          <ObjectPlayerID>75</ObjectPlayerID>
          <EventKey>40_3</EventKey>
          <EventText><span class="hometeam">Cookers</span> intimida suffisamment ses adversaires en imposant ses 75 % de possession de balle.<br /><br /></EventText>
        </Event>
      </EventList>
      <HomeGoals>6</HomeGoals>
      <AwayGoals>0</AwayGoals>
      <LastShownEventIndex>17</LastShownEventIndex>
      <NextEventMinute>50</NextEventMinute>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5595277</MatchID>
      <MatchDate>2014-12-06 14:42:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>21033</HomeTeamID>
        <HomeTeamName>Duckstad Vooruit</HomeTeamName>
        <HomeTeamShortName>Duckstad</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>509320</AwayTeamID>
        <AwayTeamName>FC Taxioni</AwayTeamName>
        <AwayTeamShortName>Taxioni</AwayTeamShortName>
      </AwayTeam>
      <EventList />
      <HomeGoals>0</HomeGoals>
      <AwayGoals>0</AwayGoals>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5595540</MatchID>
      <MatchDate>2014-12-06 16:39:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>625034</HomeTeamID>
        <HomeTeamName>Rancherias</HomeTeamName>
        <HomeTeamShortName>Rancherias</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>421141</AwayTeamID>
        <AwayTeamName>FC Kingsview</AwayTeamName>
        <AwayTeamShortName>Kingsview</AwayTeamShortName>
      </AwayTeam>
      <EventList />
      <HomeGoals>0</HomeGoals>
      <AwayGoals>0</AwayGoals>
    </Match>
    <Match>
      <SourceSystem>HTOIntegrated</SourceSystem>
      <MatchID>5595735</MatchID>
      <MatchDate>2014-12-06 18:19:00</MatchDate>
      <HomeTeam>
        <HomeTeamID>1747243</HomeTeamID>
        <HomeTeamName>-WALLONIA-</HomeTeamName>
        <HomeTeamShortName>-WALLONIA-</HomeTeamShortName>
      </HomeTeam>
      <AwayTeam>
        <AwayTeamID>221586</AwayTeamID>
        <AwayTeamName>Beybey United</AwayTeamName>
        <AwayTeamShortName>Beybey</AwayTeamShortName>
      </AwayTeam>
      <EventList />
      <HomeGoals>0</HomeGoals>
      <AwayGoals>0</AwayGoals>
    </Match>
  </MatchList>
</HattrickData>
*/

/*    public static List<String> getEventTag(String str) {
        List<String> tagValues = new ArrayList<String>();
        Pattern patt = Pattern.compile(tagPattern);
        Matcher matcher = patt.matcher(str);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }

    public static List<String> getEventValues(String str) {
        List<String> tagValues = new ArrayList<String>();
        Pattern patt = Pattern.compile(valuePattern);
        Matcher matcher = patt.matcher(str);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }*/
}
