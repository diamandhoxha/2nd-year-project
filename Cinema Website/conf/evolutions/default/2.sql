# --- Sample dataset
 
# --- !Ups
delete from CATEGORY_MOVIE;
delete from ORDER_ITEM;
delete from showing;

delete from movie;
delete from category;

delete from CATEGORY1_COMING_SOON_MOVIE;
delete from coming_soon_movie;
delete from category1;

delete from merchandise_on_sale;
delete from category3;

delete from food;
delete from category2;

ALTER TABLE MOVIE
ALTER DESCRIPTION text not null;

 
insert into category (id,title) values ( 1,'Action' );
insert into category (id,title) values ( 2,'Drama' );
insert into category (id,title) values ( 3,'Comedy' );
insert into category (id,title) values ( 4,'Horror' );
insert into category (id,title) values ( 5,'Thriller' );
insert into category (id,title) values ( 6,'Kids' );
 
insert into Movie (id,title,screen,description,seats,price) values ( 1,'Bohemian Rhapsody',1,'Bohemian Rhapsody is a foot-stomping celebration of Queen, their music and their extraordinary lead singer Freddie Mercury. Freddie defied stereotypes and shattered convention to become one of the most beloved entertainers on the planet. The film traces the meteoric rise of the band through their iconic songs and revolutionary sound. They reach unparalleled success, but in an unexpected turn Freddie, surrounded by darker influences, shuns Queen in pursuit of his solo career. Having suffered greatly without the collaboration of Queen, Freddie manages to reunite with his bandmates just in time for Live Aid. While bravely facing a recent AIDS diagnosis, Freddie leads the band in one of the greatest performances in the history of rock music. Queen cements a legacy that continues to inspire outsiders, dreamers and music lovers to this day',30, 10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 2,'A Star Is Born',2,'Seasoned musician Jackson Maine discovers -- and falls in love with -- struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jackson coaxes her into the spotlight.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 3,'Anchor Man',3,'Hotshot television anchorman Ron Burgundy (Will Ferrell) welcomes upstart reporter Veronica Corningstone (Christina Applegate) into the male-dominated world of 1970s broadcast news -- that is, until the talented female journalist begins to outshine Burgundy on air. Soon he grows jealous, begins a bitter feud with Veronica and eventually makes a vulgar slip on live TV that ruins his career.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 4,'Incidious',4,'Insidious is a series of American horror films created by James Wan and Leigh Whannell. There are four films in the franchise – Insidious, Insidious: Chapter 2, Insidious: Chapter 3 and Insidious: The Last Key – which have grossed a total of $539 million worldwide on a combined budget of $26.5 million',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 5,'Get Out',5,'Now that Chris (Daniel Kaluuya) and his girlfriend, Rose (Allison Williams), have reached the meet-the-parents milestone of dating, she invites him for a weekend getaway upstate with Missy and Dean. At first, Chris reads the familys overly accommodating behavior as nervous attempts to deal with their daughters interracial relationship, but as the weekend progresses, a series of increasingly disturbing discoveries lead him to a truth that he never could have imagined.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 6,'Lego Movie 2',6,'The citizens of Bricksburg face a dangerous new threat when LEGO DUPLO invaders from outer space start to wreck everything in their path. The battle to defeat the enemy and restore harmony to the LEGO universe takes Emmet, Lucy, Batman and the rest of their friends to faraway, unexplored worlds that test their courage and creativity.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 7,'Black panther',1,'After the death of his father, TChalla returns home to the African nation of Wakanda to take his rightful place as king. When a powerful enemy suddenly reappears, TChallas mettle as king and as Black Panther gets tested when hes drawn into a conflict that puts the fate of Wakanda and the entire world at risk. Faced with treachery and danger, the young king must rally his allies and release the full power of Black Panther to defeat his foes and secure the safety of his people',30, 10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 8,'BlacKkKlansman',2,'From visionary filmmaker Spike Lee comes the incredible true story of an American hero. It’s the early 1970s, and Ron Stallworth (John David Washington) is the first African-American detective to serve in the Colorado Springs Police Department. Determined to make a name for himself, Stallworth bravely sets out on a dangerous mission: infiltrate and expose the Ku Klux Klan. The young detective soon recruits a more seasoned colleague, Flip Zimmerman (Adam Driver), into the undercover investigation of a lifetime. Together, they team up to take down the extremist hate group as the organization aims to sanitize its violent rhetoric to appeal to the mainstream. Produced by the team behind the Academy-Award® winning Get Out.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 9,'A Quiet Place',3,'A Quiet Place is a 2018 American post-apocalyptic horror film directed by John Krasinski, who wrote the screenplay with Bryan Woods and Scott Beck. The film stars Krasinski, alongside Emily Blunt, Millicent Simmonds, and Noah Jupe.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 10,'Annihilation',4,'Based on Jeff VanderMeer’s best-selling Southern Reach Trilogy, Annihilation stars Natalie Portman, Jennifer Jason Leigh, Gina Rodriguez, Tessa Thompson, Tuva Novotny and Oscar Isaac. It was written and directed by Alex Garland (Ex Machina, 28 Days Later).',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 11,'Aquaman',5,'Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people -- and then the surface world. Standing in his way is Aquaman, Orms half-human, half-Atlantean brother and true heir to the throne. With help from royal counselor Vulko, Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 12,'Roma',6,'Cleo is one of two domestic workers who help Antonio and Sofía take care of their four children in 1970s Mexico City. Complications soon arise when Antonio suddenly runs away with his mistress and Cleo finds out that shes pregnant. When Sofía decides to take the kids on vacation, she invites Cleo for a much-needed getaway to clear her mind and bond with the family.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 13,'Eighth Grade',6,'Thirteen-year-old Kayla endures the tidal wave of contemporary suburban adolescence as she makes her way through the last week of middle school -- the end of her thus far disastrous eighth-grade year.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 14,'Venom',1,'Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drakes experiments, Eddies body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 15,'Revenge',1,'Evoking Kubricks Lolita, Jen (Matilda Lutz), arrives at a remote desert villa with her millionaire Adonis boy toy (Kevin Jannsens) for a weekend of romantic (and illicit) frivolity. Things go south quickly when her lovers unseemly hunting pals show up and make inappropriate advances that escalate into an outright assault. The men quickly try to sweep their attack under the rug, but Jen wont have it and, well... hell hath no fury....',30, 10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 16,'The Guilty',2,'Alarm dispatcher and former police officer Asger Holm answers an emergency call from a kidnapped woman. When the call is suddenly disconnected, the search for the woman and her kidnapper begins.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 17,'Mission: Impossible-Fallout',3,'Ethan Hunt and the IMF team join forces with CIA assassin August Walker to prevent a disaster of epic proportions. Arms dealer John Lark and a group of terrorists known as the Apostles plan to use three plutonium cores for a simultaneous nuclear attack on the Vatican, Jerusalem and Mecca, Saudi Arabia. When the weapons go missing, Ethan and his crew find themselves in a desperate race against time to prevent them from falling into the wrong hands.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 18,'Searching',4,'David Kim becomes desperate when his 16-year-old daughter Margot disappears and an immediate police investigation leads nowhere. He soon decides to search the one place that no one else has -- Margots laptop. Hoping to trace her digital footprints, David contacts her friends and looks at photos and videos for any possible clues to her whereabouts.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 19,'Spider-Man: Into the Spider-Verse',5,'Teen Miles Morales becomes Spider-Man of his reality, crossing his path with five counterparts from another dimensions to stop a threat for all realities.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 20,'Blindspotting',6,'Collin must make it through his final three days of probation for a chance at a new beginning in his Oakland, Calif., neighborhood. His bond with his volatile best friend soon gets tested when Collin sees a police officer shoot a suspect in the back during a chase through the streets. Things soon come to a head when the buddies attend a party at the upscale home of a young and wealthy tech entrepreneur.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 21,'You Were never Really Here',6,'When a teenage girl goes missing, a jaded, brutal enforcer attempts a rescue mission. He uncovers corruption and abuse of power along his way.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 22,'The Miseducation of Cameron Post',2,'In 1993 after teenage Cameron is caught in the backseat of a car with the prom queen, she is sent away to a treatment centre in a remote area called Gods Promise. While she is being subjected to questionable gay conversion therapies, she bonds with some fellow residents as they pretend to go along with the process while waiting to be released.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 23,'Free Solo',3,'Professional rock climber Alex Honnold attempts to conquer the first free solo climb of famed El Capitans 900-metre vertical rock face at Yosemite National Park.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 24,'A Prayer Before Dawn',4,'The amazing true story of Billy Moore, an English boxer incarcerated in Thailands most notorious prison. Thrown into a world of drugs and violence, he finds his best chance to escape is to fight his way out in Muay Thai tournaments.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 25,'Deadpool 2',5,'Wisecracking mercenary Deadpool meets Russell, an angry teenage mutant who lives at an orphanage. When Russell becomes the target of Cable -- a genetically enhanced soldier from the future -- Deadpool realizes that hell need some help saving the boy from such a superior enemy. He soon joins forces with Bedlam, Shatterstar, Domino and other powerful mutants to protect young Russell from Cable and his advanced weaponry.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 26,'Apostle',6,'London, 1905. Prodigal son Thomas Richardson has returned home, only to learn that his sister is being held for ransom by a religious cult. Determined to get her back at any cost, Thomas travels to the idyllic island where the cult lives. As Thomas infiltrates the islands community, he learns that the corruption of mainland society that they claim to reject has infested the cults ranks nonetheless - and uncovers a secret more evil than he could have imagined.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 27,'Hold the Dark',6,'Summoned to a remote Alaskan village to search for the wolves that killed three children, a wolf expert soon finds himself unravelling a harrowing mystery.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 28,'Widows',5,'A police shootout leaves four thieves dead during an explosive armed robbery attempt in Chicago. Their widows -- Veronica, Linda, Alice and Belle -- have nothing in common except a debt left behind by their spouses criminal activities. Hoping to forge a future on their own terms, Veronica joins forces with the other three women to pull off a heist that her husband was planning.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 29,'Overlord',6,'On the eve of D-Day, American paratroopers drop behind enemy lines to penetrate the walls of a fortified church and destroy a radio transmitter. As the soldiers approach their target, they soon begin to realize that theres more going on in the Nazi-occupied village than a simple military operation. Making their way to an underground lab, the outnumbered men stumble upon a sinister experiment that forces them into a vicious battle against an army of the undead.',30,10.00 );
insert into Movie (id,title,screen,description,seats,price) values ( 30,'Assassination Nation',6,'High school senior Lily and her three best friends live in a haze of texts, posts, selfies and chats -- just like the rest of the world. Their small town gets turned upside down when an anonymous hacker starts to reveal personal messages and secrets of thousands of people. As anger erupts into full-blown violence, the four girls soon find themselves in a fight for their lives against an armed mob.',30,10.00 );

insert into CATEGORY_MOVIE(category_id,movie_id) values (1,1);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,2);
insert into CATEGORY_MOVIE(category_id,movie_id) values (3,3);
insert into CATEGORY_MOVIE(category_id,movie_id) values (4,4);
insert into CATEGORY_MOVIE(category_id,movie_id) values (5,5);
insert into CATEGORY_MOVIE(category_id,movie_id) values (6,6);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,7);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,8);
insert into CATEGORY_MOVIE(category_id,movie_id) values (4,9);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,10);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,11);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,12);
insert into CATEGORY_MOVIE(category_id,movie_id) values (3,13);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,14);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,15);
insert into CATEGORY_MOVIE(category_id,movie_id) values (5,16);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,17);
insert into CATEGORY_MOVIE(category_id,movie_id) values (5,18);
insert into CATEGORY_MOVIE(category_id,movie_id) values (6,19);
insert into CATEGORY_MOVIE(category_id,movie_id) values (4,20);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,21);
insert into CATEGORY_MOVIE(category_id,movie_id) values (3,22);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,23);
insert into CATEGORY_MOVIE(category_id,movie_id) values (5,24);
insert into CATEGORY_MOVIE(category_id,movie_id) values (3,25);
insert into CATEGORY_MOVIE(category_id,movie_id) values (4,26);
insert into CATEGORY_MOVIE(category_id,movie_id) values (4,27);
insert into CATEGORY_MOVIE(category_id,movie_id) values (2,28);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,29);
insert into CATEGORY_MOVIE(category_id,movie_id) values (1,30);

insert into showing(id,movie_id,date,time,tickets,price) values (1,1,'2019-1-1',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (2,2,'2019-2-2',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (3,3,'2019-3-3',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (4,4,'2019-4-4',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (5,5,'2019-5-5',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (6,6,'2019-6-6',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (7,7,'2019-7-7',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (8,8,'2019-8-8',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (9,9,'2019-9-9',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (10,10,'2019-10-10',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (11,11,'2019-11-11',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (12,12,'2019-12-12',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (13,13,'2019-1-13',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (14,14,'2019-2-14',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (15,15,'2019-3-15',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (16,16,'2019-4-16',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (17,17,'2019-5-17',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (18,18,'2019-6-18',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (19,19,'2019-7-19',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (20,20,'2019-8-20',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (21,21,'2019-9-21',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (22,22,'2019-10-22',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (23,23,'2019-11-23',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (24,24,'2019-12-24',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (25,25,'2019-1-25',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (26,26,'2019-2-26',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (27,27,'2019-3-27',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (28,28,'2019-4-28',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (29,29,'2019-5-1',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (30,30,'2019-6-2',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (31,1,'2019-1-3',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (32,2,'2019-2-4',12.00,30,30);
insert into showing(id,movie_id,date,time,tickets,price) values (33,3,'2019-3-5',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (34,4,'2019-4-6',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (35,5,'2019-5-7',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (36,6,'2019-6-8',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (37,7,'2019-7-9',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (38,8,'2019-8-10',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (39,9,'2019-9-11',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (40,10,'2019-10-12',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (41,11,'2019-11-13',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (42,12,'2019-12-14',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (43,13,'2019-1-15',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (44,14,'2019-2-16',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (45,15,'2019-3-17',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (46,16,'2019-4-18',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (47,17,'2019-5-19',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (48,18,'2019-6-20',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (49,19,'2019-7-21',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (50,20,'2019-8-22',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (51,21,'2019-9-23',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (52,22,'2019-10-24',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (53,23,'2019-11-25',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (54,24,'2019-12-26',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (55,25,'2019-1-27',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (56,26,'2019-2-28',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (57,27,'2019-3-1',1.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (58,28,'2019-4-2',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (59,29,'2019-5-3',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (60,30,'2019-6-4',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (61,1,'2019-1-5',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (62,2,'2019-2-6',14.00,30,30);
insert into showing(id,movie_id,date,time,tickets,price) values (63,3,'2019-3-7',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (64,4,'2019-4-8',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (65,5,'2019-5-9',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (66,6,'2019-6-10',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (67,7,'2019-7-11',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (68,8,'2019-8-12',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (69,9,'2019-9-13',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (70,10,'2019-10-14',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (71,11,'2019-11-15',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (72,12,'2019-12-16',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (73,13,'2019-1-17',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (74,14,'2019-2-18',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (75,15,'2019-3-19',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (76,16,'2019-4-20',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (77,17,'2019-5-21',16.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (78,18,'2019-6-22',17.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (79,19,'2019-7-23',18.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (80,20,'2019-8-24',19.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (81,21,'2019-9-25',20.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (82,22,'2019-10-26',21.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (83,23,'2019-11-27',09.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (84,24,'2019-12-28',10.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (85,25,'2019-1-1',11.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (86,26,'2019-2-2',12.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (87,27,'2019-3-3',13.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (88,28,'2019-4-4',14.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (89,29,'2019-5-5',15.00,30,10);
insert into showing(id,movie_id,date,time,tickets,price) values (90,30,'2019-6-6',16.00,30,10);



insert into category2 (id,name) values ( 600,'food' );
insert into category2 (id,name) values ( 601,'Drink' );

insert into food (id,category2_id,name,size,price) values ( 400,600,'pepsi','large',5.0);
insert into food (id,category2_id,name,size,price) values ( 401,601,'popcorn','large',5.0);
insert into food (id,category2_id,name,size,price) values ( 402,600,'water','small',2.50);
insert into food (id,category2_id,name,size,price) values ( 403,601,'waffle','small',2.50);


insert into category1 (id,title) values ( 1,'Action' );
insert into category1 (id,title) values ( 2,'Drama' );
insert into category1 (id,title) values ( 3,'Comedy' );
insert into category1 (id,title) values ( 4,'Horror' );
insert into category1 (id,title) values ( 5,'Thriller' );
insert into category1 (id,title) values ( 6,'Kids' );

insert into coming_soon_movie (id,title,description) values ( 100,'Expendables','jjjj');
insert into coming_soon_movie (id,title,description) values ( 101,'A Star Is Born','hhhhhhh');
insert into coming_soon_movie (id,title,description) values ( 102,'Anchor Man','ffffffff');
insert into coming_soon_movie (id,title,description) values ( 103,'Incidious','jjjjjjjj');
insert into coming_soon_movie (id,title,description) values ( 104,'Get Out','jjjjjjjj');
insert into coming_soon_movie (id,title,description) values ( 105,'Lego Movie 2','hhhhhhh');

insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (1,100);
insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (2,101);
insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (3,102);
insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (4,103);
insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (5,104);
insert into CATEGORY1_COMING_SOON_MOVIE(category1_id,coming_soon_movie_id) values (6,105);


insert into category3 (id,name) values ( 1,'Hats' );
insert into category3 (id,name) values ( 2,'T-shirts' );
insert into category3 (id,name) values ( 3,'Mugs' );
insert into category3 (id,name) values ( 4,'Bobble heads' );

 
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 300,1,'Marvel Hat',5, 20 );
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 301,2,'Marvel T-shirt',1,3.00 );
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 302,3,'Fluffy Socks',100,2.00 );
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 305,4,'Tumbler Glass',40,1.00 );
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 306,2,'Piano',1,99.00 );
insert into merchandise_on_sale (id,category3_id,name,stock,price) values ( 307,4,'Chair',1,50.00 );
