-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost:3306
-- Üretim Zamanı: 31 May 2019, 22:17:45
-- Sunucu sürümü: 10.0.38-MariaDB-cll-lve
-- PHP Sürümü: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `u8250606_chard`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `fill_blanks`
--

CREATE TABLE `fill_blanks` (
  `id` int(11) NOT NULL,
  `word` varchar(255) NOT NULL,
  `word_type` varchar(1) NOT NULL,
  `meaning` varchar(255) NOT NULL,
  `sentence` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `fill_blanks`
--

INSERT INTO `fill_blanks` (`id`, `word`, `word_type`, `meaning`, `sentence`) VALUES
(1, 'range', 'n', 'variety,kinds', 'I saw a range of colours/patterns on the carpet'),
(2, 'principal', 'n', 'manager', 'There are seven theachers and a principal at the school'),
(3, 'encourage', 'v', 'persuade', 'My parents encourage me when thing were not going well at school'),
(4, 'enhance', 'v', 'improve', 'I need to enhance my English ability to pass exam.'),
(5, 'evidence', 'n', 'something that makes you believe that something is true or exists.', 'There is no scientific evidence that the drug is addictive.'),
(6, 'expand', 'v', 'to become larger in size,number,or,amount,or to make something become larger.', 'Sydney s popilation expanded rapidly in the 1960 s.'),
(7, 'recess', 'n', 'a period of time when the proceedings of a parliament, committee, court of law, or other official body are temporarily suspended.', 'The court is in recess for thirty minutes.'),
(8, 'remedy', 'n', 'some thing that solves a problem', 'The remedy for the traffic problem is to encourage to use public transport.'),
(9, 'intention', 'n', 'something that you want and plan to do', 'I have no intention of seeing him again.'),
(10, 'expect', 'v', 'to think that something will happen', 'I expect that she will be very angry about this.'),
(11, 'reject', 'v', 'to refuse to someone or something', 'I applied to Cambridge Un. but I was rejected.'),
(12, 'interact', 'v', 'to communicate somebody, especially while you work,play or spend time with them', 'Lucy interacts well with other children in the class.'),
(13, 'disturb', 'v', 'to intterupt someone so that they connect continue what they are doing', 'Don\'t disturb him ,he needs to sleep.'),
(14, 'disability', 'n', 'a physical or mental condition that means you can\'t use a part of your body completely or easly, or that you can\'t learn easily', 'Public places are becoming more accesible to people with disabilities.'),
(15, 'process', 'v', 'to deal with information/ use information', 'The new network will enable data to be processed more speedily.'),
(16, 'retrieve', 'v', 'to find and get back data or information that has been stored in the memory of a computer, remember,get back.', 'I was sent to retrieve the balls from his garden'),
(17, 'anxious', 'a', 'worried or nervous about something', 'Parents are naturally anxious for their children.'),
(18, 'qualification', 'n', 'a skill,personal quality,or type of experience that makes you suitable for a particular job or position', 'Previous teaching experience is a necessary qualification for this job.'),
(19, 'entrepreneur', 'n', 'someone who starts a new businnes or arranges bussines deals in order to make money.', 'Mark Zuckernerg is a famous entreprenuer.'),
(20, 'adapt', 'v', 'to change your behaviour and attidues in order to be succesful in a new situation.', 'The children are finding it hard to adapt to the new school.'),
(21, 'suit', 'v', 'to be convenient or useful somebody', 'Blue suits you. You should wear it more often.'),
(22, 'colleague', 'n', 'someone you work with, co-worker.', 'She discussed the idea with some of her colleagues.'),
(23, 'practical', 'a', 'a practical person is good at dealing with problems and making decisions.', 'She has a lot of interesting ideas but she\'s not very practical.'),
(24, 'introduce', 'v', 'when you introduce something, you show something new to people', 'The company introducing a new range of products this year.'),
(25, 'confident', 'a', 'feeling sure about your own ability to do things and be succesful.', 'I feel much more confident about myself and my abilities these days'),
(26, 'profit', 'n', 'money that you earn by selling things or doing bussinnes after your costs have been paid', 'We are in businnes to make a profit.'),
(27, 'invest', 'v', 'to put money', 'The institute will invest five million in the project'),
(28, 'destruction', 'n', 'destroying something', 'many people are concerned about the destruction of the rainforests'),
(29, 'penalty', 'n', 'punishment', 'the maximum penalty for the offence is a 1000tl fine'),
(30, 'trade', 'n', 'the activity of buying and selling', 'we are planning to develop our export trade'),
(31, 'funding', 'n', 'financial booking', 'Alisha is trying to get funding for her research'),
(32, 'release', 'v', 'make free', 'he was released from prison'),
(33, 'fine', 'n', 'a punishment for not obeying a rule', 'I have just had to pay 10tl for a parking fine'),
(34, 'disease', 'n', 'illness', 'the first symptom of the disease is very high temperature'),
(35, 'decline', 'n', 'go down', 'He interest in the project declined ofter his wife died'),
(36, 'distinctive', 'a', 'unique', 'She has got a very distinctive voice'),
(37, 'harsh', 'a', 'unpleasant', '\"The is no alternative\"she said a harsh voice'),
(38, 'reduction', 'n', 'decrease', 'Competittion in the market has led to a reduction in the company\'s profits this year'),
(39, 'mention', 'v', 'speak', 'He mentioned that he was leaving his job.'),
(40, 'currently', 'a', 'at the present time', 'He always is directing TV sitcoms.'),
(41, 'source', 'n', 'origin,root', 'a source of heat/energy/light'),
(42, 'proficient', 'a', 'skilled and experienced', 'She is proficient in two languages.'),
(43, 'instinct', 'n', 'the way people or animals naturally react or behave', 'Her first instinct was to run.'),
(44, 'accurently', 'a', 'without making any mistakes/correctly', 'He speaks English fluently and accurently.'),
(45, 'pressure', 'n', 'persuade,influence', 'Can you work well under pressure?'),
(46, 'reliable', 'a', 'able to be trusted or believed', 'Andy is very reliable - if he says he will do something, he will do it.'),
(47, 'privacy', 'n', 'the state of being alone so that people. cannot see or hear what you are doing.', 'I hate sharing a bedroom- I never get any privacy'),
(48, 'comment', 'v', 'express an opinion or reaction in speech or writing', 'My mum always comments on what I am wearing.'),
(49, 'annoy', 'v', 'to make someone slightly angry', 'She annoyed him with her stupid questions.'),
(50, 'time-consuming', 'a', 'needing or taking a lot of time.', 'In the past, it used to be very time-consuming to download huge files.'),
(51, 'particulary', 'a', 'especially', 'I didn\'t particularly want to go, but I had to.'),
(52, 'resemble', 'v', 'to look like/similar to', 'You resemble your cat very closely.'),
(53, 'accelerate', 'v', 'the speed of the vehicle increases, speed up.', 'I accelerated to overtake the bus.'),
(54, 'punctual', 'a', 'on time', 'He is fairly punctual, he usually arrives on time.'),
(55, 'expect', 'v', 'anticipate/think', 'Gosh,I didn\'t expect to see you here!'),
(56, 'react', 'v', 'act, respond,behave', 'She reacted calmly to the news of his death.'),
(57, 'suspicious', 'a', 'doubtful', 'We became suspicious when the letter did not arrive.'),
(58, 'relate', 'v', 'connect', 'It is related to our subject.'),
(59, 'receive', 'v', 'get', 'Did you receive my letter?'),
(60, 'appreciation', 'n', 'gratitude,thankfulness', 'The crowd cheered in appreciation'),
(61, 'tend to', 'v', 'be likely', 'I think you tend to eat more in the winter.'),
(62, 'appointment', 'n', 'arrangement', 'I\'d like to make an appointment with Dr.Evans, please.'),
(63, 'requirement', 'n', 'something that you must do.', 'A good degree is a minimum requirement for many jobs.'),
(64, 'occasion', 'n', 'circumstance', 'Congratulations on the occasion of your wedding anniversary.'),
(65, 'aspect', 'n', 'one part of a situation, problem, subject', 'Which aspects of the job do you meet enjoy?'),
(66, 'permission', 'n', 'be allowed', 'You will need permission from your parents to go on the trip.'),
(67, 'flood', 'n', 'a large amount of water covering an area that is usually dry', 'The heavy rain has caused floods in many parts of the country.'),
(68, 'root', 'n', 'the part of a plant or three that grows under the ground and gets water from the sail', 'I pulled the plant up by the roots.'),
(69, 'resident', 'n', 'a person who lives in a particular place', 'Parking spaces are for residents only.'),
(70, 'goods', 'n', 'things that are produced in order to be sold', 'electrical/industrial/agricultural etc. goods'),
(71, 'consider', 'v', 'to think about something carefully, especially in order to make a decision.', 'She considered her options.'),
(72, 'avoid', 'v', 'to stay away from someone or something.', 'You should avoid eating fast food if you want to be healthy.'),
(73, 'disaster', 'n', 'a sudden event such as a flood, storm or accident which causes great damage or suffering.', 'The economic consequences of the Chernobyl nuclear disaster.'),
(74, 'realistic', 'a', 'possible to achieve', 'We must set realistic goals.'),
(75, 'convenience', 'n', 'the qualityof being useful, easy or suitable for somebody.', 'Ready meds sell well because of their convenience.'),
(76, 'prevent', 'v', 'to stop somebody from doing something; to stop something from happening', 'The governmenttook steps ton prevent a scandal.'),
(77, 'afford', 'v', 'to have enough money or time to be able to buy or to do something.', 'Can we afford a new car?'),
(78, 'substantial', 'a', 'large in amount , value or importance', 'The are substantial differences between the two groups.'),
(79, 'concern', 'n', 'a feeling of worry about something important.', 'The recent rise in crime is a matter of considerable public concern'),
(80, 'outweigh', 'v', 'to be greater or more important than something', 'The advantages of the internet outweigh the disadvantages.'),
(81, 'deliver', 'v', 'to take goods, letters,packages etc to a particular place or a person.', 'They set off to deliver supplies to an isolated village.'),
(82, 'contribute', 'v', 'to be one of the causes of something', 'Alcohol contributes to 100.000 deaths a year in the US.'),
(83, 'tackle', 'v', 'to try to deal with a difficult problem, overcome', 'There is more than one way to tackle the problem.'),
(84, 'chop', 'v', 'to cut something in to pieces', 'He was chopping wood in the yard'),
(85, 'complain', 'v', 'to say that something is wrong', 'Lots of people have complained about the noise.'),
(86, 'tendency', 'v', 'habit', 'Jean is nice but she has a tendency to talk too much.'),
(87, 'deprive', 'v', 'to prevent someone from having something, remove', 'A lot of these children have been deprived of a normal life.'),
(88, 'deprivation', 'n', 'lack, deficiency', 'Sleep deprivation can result in mental disorders.'),
(89, 'impair', 'v', 'damage, harm', 'The illness had impaired his ability to think and concentrate.'),
(90, 'adjust', 'v', 'to change something slightly to make it more suitable for a new set of conditions', 'This button is for adjusting the volume.'),
(91, 'adapt', 'v', 'to gradually change your behavior attitudes in order to be successful in a new situation', 'The children are finding it hard to adapt to the new school.'),
(92, 'depend on', 'v', 'to be affected by something', 'Whether we need more food depends on how many people turn up.'),
(93, 'operate', 'v', 'to work in particlar way,function', 'Solar panels can only operate in sunlight.'),
(94, 'scene', 'n', 'a part of a film/movie,play or book in which the action happens in place', 'Hamlet/ Act 5 / scene 2'),
(95, 'budget', 'n', 'a plan of money how it wil be spent', 'The organization has an annual budget of $24 million budget'),
(96, 'permission', 'n', 'if you have permission to do something , you are officially allowed to do it.', 'You have to get permission from your parents if you want to come.'),
(97, 'angle', 'n', 'a position from which you lack at something', 'The photo was taken from an unusual angle'),
(98, 'fatigue', 'n', 'feeling of being extremely tired, usually because of hard work or exercise', 'He is suffering from physical and mental fatigue'),
(99, 'selected', 'v', 'to choose,pick up', 'She selected an apple from six finalists.'),
(100, 'discussion', 'n', 'a conversation about somebody/someething a topic/subject for discussion.', 'After some discussion , they decided to accept our offer.'),
(101, 'worth', 'a', 'important ,good or enjoyable enough to make somebody feel happy, satisfied', 'The job involves a lot of hard work but it is worth it.'),
(102, 'provide', 'v', 'to give something to somebody, supply', 'The hospital has a commitment to provide the best possible medical care'),
(103, 'particular', 'a', 'specific, certain', 'You should pay particular attention to spelling.'),
(104, 'recommend', 'v', 'to advise someone to do something ,suggest', 'Doctors strongly recommend that fathers should be present at their baby\'s birth.'),
(105, 'wonder', 'v', 'to think about something try to decide what is true, what wil happen , what you should do;want to learn', 'I wonder why he left his job.'),
(106, 'capture', 'v', 'to catch an animal after chosing or following it', 'The tiger was finally captured two miles outside the villages.'),
(107, 'relocate', 'v', 'move to different place', 'Next year we may relocate to Denver'),
(108, 'treat', 'v', 'to give medical came to someone for an illnes or injury', 'He is being treated for cancer at a hospital in Iskenderun.'),
(109, 'exist', 'v', 'to be really', 'Does life exist on other planets?'),
(110, 'convince', 'v', 'to persuade someone or to make them certain', 'I convinced her to go to the doctors.'),
(111, 'abandon', 'v', 'to leave someone or something somewhere,something not returning to get them', 'We had to abandon the car and walk the rest of the way'),
(112, 'abuse', 'n', 'cruel,violent,or unfair treatment of someone', 'Many children suffer racial abuse at school.'),
(113, 'analyze', 'v', 'to examine the detail of sth carefully in order to understand or explain it.', 'The data is collected and then analyzed on computer.'),
(114, 'debate', 'n', 'discussion or argument about a sunbject', 'There has been a lor of public debate on the safety of food.'),
(115, 'Domestic', 'a', 'a domestic animal lives on a form or in someone\'s home,not in wild', 'Domestic pets.'),
(116, 'issue', 'n', 'an important subject or problem that people are discussing.', 'People shouldn\'t bring their personal issues into work.'),
(117, 'claim', 'v', 'to state that something is true, even through it has not been proved', 'The product claims that it can make you thin wihout dieting.'),
(118, 'face', 'v', 'to confort directly, deal with', 'She faced many difficulties during the project');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `schedule`
--

CREATE TABLE `schedule` (
  `qid` int(11) NOT NULL,
  `word_id` int(11) NOT NULL,
  `user_nick_name` varchar(120) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `date` date NOT NULL,
  `efactor` double NOT NULL DEFAULT '2.5',
  `asked` tinyint(1) NOT NULL DEFAULT '0',
  `repeat_time` int(11) NOT NULL DEFAULT '0',
  `old_interval` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_date` date NOT NULL,
  `user_hour` time NOT NULL,
  `user_nick_name` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `user_email` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `user_password` varchar(120) COLLATE utf8_turkish_ci NOT NULL,
  `user_score` double NOT NULL,
  `user_true_ans` int(11) NOT NULL,
  `user_false_ans` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `fill_blanks`
--
ALTER TABLE `fill_blanks`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`qid`),
  ADD KEY `word_id` (`word_id`),
  ADD KEY `user_id` (`user_nick_name`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `fill_blanks`
--
ALTER TABLE `fill_blanks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- Tablo için AUTO_INCREMENT değeri `schedule`
--
ALTER TABLE `schedule`
  MODIFY `qid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=213;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
