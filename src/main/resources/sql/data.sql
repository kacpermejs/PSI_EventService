DELETE FROM event_post;
DELETE FROM event;
DELETE FROM venue_schematic;

-- Insert VenueSchematic data
INSERT INTO venue_schematic (id, name) VALUES
(1, 'Venue 1'),
(2, 'Venue 2');

-- Insert Event data with EventStatus enum mapped as smallint
-- Active = 0, Canceled = 1, Finished = 2, Draft = 3
INSERT INTO event (id, venue_schematic_id, description, location, status, sale_start_date, event_start_date, sale_end_date) VALUES
(1, 1, 'Live concert by a famous band', 'New York', 0, '2025-02-01 10:00:00', '2025-02-05 20:00:00', '2025-02-01 22:00:00'),
(2, 2, 'Art exhibition opening night', 'Paris', 1, '2025-03-01 12:00:00', '2025-03-05 18:00:00', '2025-03-02 22:00:00'),
(3, 1, 'Stand-up comedy night', 'Los Angeles', 2, '2025-04-01 15:00:00', '2025-04-10 19:00:00', '2025-04-02 23:00:00'),
(4, 2, 'Food festival', 'London', 3, '2025-05-01 08:00:00', '2025-05-10 12:00:00', '2025-05-05 22:00:00');

-- Insert EventPost data
INSERT INTO event_post (id, event_id, title, description, thumbnail_url) VALUES
(1, 1, 'Band Concert Event Post', 'Details about the concert including special performances', 'http://example.com/thumbnail1.jpg'),
(2, 2, 'Art Exhibit Announcement', 'Opening night details for the upcoming art exhibition', 'http://example.com/thumbnail2.jpg'),
(3, 3, 'Comedy Night Promo', 'Stand-up comedy night with several famous comedians', 'http://example.com/thumbnail3.jpg'),
(4, 4, 'Festival Highlights', 'Everything you need to know about the upcoming food festival', 'http://example.com/thumbnail4.jpg');
