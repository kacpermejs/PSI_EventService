DELETE FROM address;
DELETE FROM event_facility;
DELETE FROM venue;

DELETE FROM venue_schematic;
DELETE FROM schematic_object;
DELETE FROM venue_section;
DELETE FROM seat;

DELETE FROM event;
DELETE FROM event_post;

INSERT INTO address (
    id, address_line1, address_line2, city, country, postal_code, state_or_region)
VALUES
(200, 'pl. Wolności 1', NULL, 'Wrocław', 'Poland', '50-071', 'Dolnośląskie'),
(201, 'al. Krakowska 10', NULL, 'Wrocław', 'Poland', '50-015', 'Dolnośląskie');

INSERT INTO event_facility (id, address_id, name)
VALUES
(1, 200, 'Narodowe Forum Muzyki im. Witolda Lutosławskiego'),
(2, 201, 'Sala Koncertowa Radia Wrocław');

INSERT INTO venue (id, event_facility_id, name)
VALUES
(1, 1, 'Sala główna'),
(2, 1, 'Sala czerwona'),
(3, 2, 'Sala główna');

-- Insert VenueSchematic data
INSERT INTO venue_schematic (id, venue_id, name)
VALUES
(1, 1, 'Schemat podstawowy sali głownej'),
(2, 2, 'Schemat podstawowy sali czerwonej'),
(3, 3, 'Schemat podstawowy sali głownej');

INSERT INTO schematic_object (id, name, label, show_label, schematic_id, parent_id, angle, layer, x, y)
VALUES
(1, 'Section A', 'A',     true, 1, NULL, 0.0,  0,  0.0,  0.0),  -- Root object for section A
(2, 'Row 1',     '',      true, 1, 1,    0.0,  1,  0.0,  0.0),      -- Grouping object for row 1 in section A
(3, 'Seat 1',    '',      true, 1, 2,    0.0,  2, -5.0,  0.0),        -- Child of object 1 (seat 1 row 1)
(4, 'Seat 2',    '',      true, 1, 2,    0.0,  2,  5.0,  0.0),        -- Child of object 1 (seat 2 row 1)
(5, 'Section B', 'B',     true, 1, NULL, 0.0,  0,  0.0, -10.0), -- Root object for section B
(6, 'Row 1',     '',      true, 1, 5,    20.0, 1,  0.0,  0.0),     -- Grouping object for row 1 in section B
(7, 'Seat 1',    '',      true, 1, 6,    0.0,  2, -8.0,  0.0),      -- Child of object 2 (seat 1 section B)
(8, 'Scene',     'Scena', true, 1, NULL, 0.0,  2, -8.0,  0.0);      -- Scene

INSERT INTO venue_section (id, schematic_object_id, capacity, label)
VALUES
(1, 1, NULL, 'Section A'),  -- Section for schematic object 1
(2, 4, NULL, 'Section B');   -- Section for schematic object 2

-- Insert Seat data with SeatType enum mapped as smallint
-- Single = 0, Double = 1, Disabled = 2, Custom = 3
INSERT INTO seat (id, schematic_object_id, venue_section_id, capacity, type, label, name, seat_column, seat_row)
VALUES
(1, 2, 1, 1, 0, 'r1m1sA', NULL, '1', '1'), -- Seat in Section A
(2, 3, 1, 1, 0, 'r1m2sA', NULL, '2', '1'), -- Another seat in Section A
(3, 5, 2, 1, 0, 'r1m2sB', NULL, '1', '1'); -- Seat in Section B

-- Insert Event data with EventStatus enum mapped as smallint
-- Active = 0, Canceled = 1, Finished = 2, Draft = 3
INSERT INTO event (id, venue_schematic_id, status, sale_start_date, event_start_date, sale_end_date) VALUES
(1, 1, 0, '2025-02-01 10:00:00', '2025-02-05 20:00:00', '2025-02-01 22:00:00'),
(2, 1, 1, '2025-03-01 12:00:00', '2025-03-05 18:00:00', '2025-03-02 22:00:00'),
(3, 1, 2, '2025-04-01 15:00:00', '2025-04-10 19:00:00', '2025-04-02 23:00:00'),
(4, 1, 3, '2025-05-01 08:00:00', '2025-05-10 12:00:00', '2025-05-05 22:00:00');

-- Insert EventPost data
INSERT INTO event_post (id, event_id, title, description, location, thumbnail_url) VALUES
(1, 1, 'Band Concert Event Post',  'Details about the concert including special performances',     'Worcław', 'https://picsum.photos/300/200?random=1'),
(2, 2, 'Art Exhibit Announcement', 'Opening night details for the upcoming art exhibition',        'Worcław', 'https://picsum.photos/300/200?random=2'),
(3, 3, 'Comedy Night Promo',       'Stand-up comedy night with several famous comedians',          'Worcław', 'https://picsum.photos/300/200?random=3'),
(4, 4, 'Festival Highlights',      'Everything you need to know about the upcoming food festival', 'Worcław', 'https://picsum.photos/300/200?random=4');
