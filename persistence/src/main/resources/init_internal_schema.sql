# Attention! This will truncate the class, attribute, attributepath and schema tables!
# A schema for bibo:Document will be created


SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

TRUNCATE TABLE `ATTRIBUTE`;
INSERT INTO `ATTRIBUTE` (`ID`, `NAME`, `URI`) VALUES
(1, 'title', 'http://purl.org/dc/elements/1.1/title'),
(2, 'otherTitleInformation', 'http://rdvocab.info/Elements/otherTitleInformation'),
(3, 'alternative', 'http://purl.org/dc/terms/alternative'),
(4, 'shortTitle', 'http://purl.org/ontology/bibo/shortTitle'),
(5, 'creator', 'http://purl.org/dc/terms/creator'),
(6, 'creator', 'http://purl.org/dc/elements/1.1/creator'),
(7, 'contributor', 'http://purl.org/dc/terms/contributor'),
(8, 'contributor', 'http://purl.org/dc/elements/1.1/contributor'),
(9, 'publicationStatement', 'http://rdvocab.info/Elements/publicationStatement'),
(10, 'placeOfPublication', 'http://rdvocab.info/Elements/placeOfPublication'),
(11, 'publisher', 'http://purl.org/dc/elements/1.1/publisher'),
(12, 'issued', 'http://purl.org/dc/terms/issued'),
(13, 'sameAs', 'http://www.w3.org/2002/07/owl#sameAs'),
(14, 'isLike', 'http://umbel.org/umbel#isLike'),
(15, 'issn', 'http://purl.org/ontology/bibo/issn'),
(16, 'eissn', 'http://purl.org/ontology/bibo/eissn'),
(17, 'lccn', 'http://purl.org/ontology/bibo/lccn'),
(18, 'oclcnum', 'http://purl.org/ontology/bibo/oclcnum'),
(19, 'isbn', 'http://purl.org/ontology/bibo/isbn'),
(20, 'type', 'http://www.w3.org/1999/02/22-rdf-syntax-ns#type'),
(21, 'medium', 'http://purl.org/dc/terms/medium'),
(22, 'hasPart', 'http://purl.org/dc/terms/hasPart'),
(23, 'isPartOf', 'http://purl.org/dc/terms/isPartOf'),
(24, 'hasVersion', 'http://purl.org/dc/terms/hasVersion'),
(25, 'isFormatOf', 'http://purl.org/dc/terms/isFormatOf'),
(26, 'precededBy', 'http://rdvocab.info/Elements/precededBy'),
(27, 'succeededBy', 'http://rdvocab.info/Elements/succeededBy'),
(28, 'language', 'http://purl.org/dc/terms/language'),
(29, '1053', 'http://iflastandards.info/ns/isbd/elements/1053'),
(30, 'edition', 'http://purl.org/ontology/bibo/edition'),
(31, 'bibliographicCitation', 'http://purl.org/dc/terms/bibliographicCitation'),
(32, 'familyName', 'http://xmlns.com/foaf/0.1/familyName'),
(33, 'givenName', 'http://xmlns.com/foaf/0.1/givenName');

TRUNCATE TABLE `ATTRIBUTES_ATTRIBUTE_PATHS`;
INSERT INTO `ATTRIBUTES_ATTRIBUTE_PATHS` (`ATTRIBUTE_PATH_ID`, `ATTRIBUTE_ID`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(32, 5),
(33, 5),
(34, 5),
(6, 6),
(7, 7),
(35, 7),
(36, 7),
(37, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(32, 20),
(35, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24),
(25, 25),
(26, 26),
(27, 27),
(28, 28),
(29, 29),
(30, 30),
(31, 31),
(33, 32),
(36, 32),
(34, 33),
(37, 33);

TRUNCATE TABLE `ATTRIBUTE_PATH`;
INSERT INTO `ATTRIBUTE_PATH` (`ID`, `ATTRIBUTE_PATH`) VALUES
(1, '[1]'),
(2, '[2]'),
(3, '[3]'),
(4, '[4]'),
(5, '[5]'),
(6, '[6]'),
(7, '[7]'),
(8, '[8]'),
(9, '[9]'),
(10, '[10]'),
(11, '[11]'),
(12, '[12]'),
(13, '[13]'),
(14, '[14]'),
(15, '[15]'),
(16, '[16]'),
(17, '[17]'),
(18, '[18]'),
(19, '[19]'),
(20, '[20]'),
(21, '[21]'),
(22, '[22]'),
(23, '[23]'),
(24, '[24]'),
(25, '[25]'),
(26, '[26]'),
(27, '[27]'),
(28, '[28]'),
(29, '[29]'),
(30, '[30]'),
(31, '[31]'),
(32, '[5,20]'),
(33, '[5,32]'),
(34, '[5,33]'),
(35, '[7,20]'),
(36, '[7,32]'),
(37, '[7,33]');

TRUNCATE TABLE `ATTRIBUTE_PATHS_SCHEMAS`;
INSERT INTO `ATTRIBUTE_PATHS_SCHEMAS` (`SCHEMA_ID`, `ATTRIBUTE_PATH_ID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(1, 37);

TRUNCATE TABLE `CLASS`;
INSERT INTO `CLASS` (`ID`, `NAME`, `URI`) VALUES
(1, 'Document', 'http://purl.org/ontology/bibo/Document');

TRUNCATE TABLE `DATA_SCHEMA`;
INSERT INTO `DATA_SCHEMA` (`ID`, `NAME`, `RECORD_CLASS`) VALUES
(1, 'Internal Schema', 1);

TRUNCATE TABLE `DATA_MODEL`;
INSERT INTO `DATA_MODEL` (ID, NAME, DESCRIPTION, CONFIGURATION, DATA_RESOURCE, DATA_SCHEMA) VALUES
  (1, 'Internal Data Model', 'SLUB Internal Data Model', null, null, 1);

SET FOREIGN_KEY_CHECKS=1;