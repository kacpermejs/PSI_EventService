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

INSERT INTO schematic_object (id, name, label, show_label, schematic_id, parent_id, angle, layer, x, y, width, height)
VALUES
(1,  'Section A',   'A',    true, 1, NULL,  0.0, 0,     0.0,    -180.0, 200.0,  100.0),  -- Root object for section A
(2,  'Row 1',       '',     true, 1, 1,     0.0, 1,     10.0,   30.0,   180.0,  20.0),     -- Grouping object for row 1 in section A
(3,  'Seat 1',      '',     true, 1, 2,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 1 (seat 1 row 1)
(4,  'Seat 2',      '',     true, 1, 2,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 1 (seat 2 row 1)
(5,  'Row 2',       '',     true, 1, 1,     0.0, 1,     10.0,   60.0,   180.0,  20.0),     -- Grouping object for row 2 in section A
(6,  'Seat 3',      '',     true, 1, 5,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 5 (seat 3 row 2)
(7,  'Seat 4',      '',     true, 1, 5,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 5 (seat 4 row 2)
(8,  'Section B',   'B',    true, 1, NULL,  0.0, 0,     220.0, -180.0,  200.0,  100.0),  -- Root object for section B
(9,  'Row 1',       '',     true, 1, 8,     0.0, 1,     10.0,   30.0,   180.0,  20.0),     -- Grouping object for row 1 in section B
(10, 'Seat 1',      '',     true, 1, 9,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 9 (seat 5 row 1)
(11, 'Seat 2',      '',     true, 1, 9,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 9 (seat 6 row 1)
(12, 'Row 2',       '',     true, 1, 8,     0.0, 1,     10.0,   60.0,   180.0,  20.0),     -- Grouping object for row 2 in section B
(13, 'Seat 3',      '',     true, 1, 12,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 12 (seat 7 row 2)
(14, 'Seat 4',      '',     true, 1, 12,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 12 (seat 8 row 2)
(15, 'Section C',   'C',    true, 1, NULL,  0.0, 0,     0.0,    -20.0,  200.0,  100.0),  -- Root object for section C
(16, 'Row 1',       '',     true, 1, 15,     0.0, 1,     10.0,   30.0,   180.0,  20.0),     -- Grouping object for row 1 in section C
(17, 'Seat 1',      '',     true, 1, 16,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 16 (seat 9 row 1)
(18, 'Seat 2',      '',     true, 1, 16,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 16 (seat 10 row 1)
(19, 'Row 2',       '',     true, 1, 15,     0.0, 1,     10.0,   60.0,   180.0,  20.0),     -- Grouping object for row 2 in section C
(20, 'Seat 3',      '',     true, 1, 19,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 19 (seat 11 row 2)
(21, 'Seat 4',      '',     true, 1, 19,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 19 (seat 12 row 2)
(22, 'Section D',   'D',    true, 1, NULL,  0.0, 0,     0.0,    -30.0,  200.0,  100.0),  -- Root object for section D
(23, 'Row 1',       '',     true, 1, 22,     0.0, 1,     10.0,   30.0,   180.0,  20.0),     -- Grouping object for row 1 in section D
(24, 'Seat 1',      '',     true, 1, 23,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 23 (seat 13 row 1)
(25, 'Seat 2',      '',     true, 1, 23,     0.0, 2,     15.0,   5.0,    10.0,   10.0),       -- Child of object 23 (seat 14 row 1)
(26, 'Row 2',       '',     true, 1, 22,     0.0, 1,     10.0,   60.0,   180.0,  20.0),     -- Grouping object for row 2 in section D
(27, 'Seat 3',      '',     true, 1, 26,     0.0, 2,     5.0,    5.0,    10.0,   10.0),       -- Child of object 26 (seat 15 row 2)
(28, 'Seat 4',      '',     true, 1, 26,     0.0, 2,     15.0,   5.0,    10.0,   10.0);       -- Child of object 26 (seat 16 row 2)


-- Inserting venue section data
INSERT INTO venue_section (id, schematic_object_id, schematic_id, capacity, label)
VALUES
(1, 1, 1, NULL, 'Section A'),  -- Section for schematic object 1
(2, 8, 1, NULL, 'Section B'),  -- Section for schematic object 2
(3, 15, 1, NULL, 'Section C'), -- Section for schematic object 15
(4, 22, 1, NULL, 'Section D'); -- Section for schematic object 22

-- Inserting seat data
-- SeatType enum mapped as smallint: Single = 0, Double = 1, Disabled = 2, Custom = 3
INSERT INTO seat (id, schematic_id, schematic_object_id, venue_section_id, capacity, type, label, name, seat_column, seat_row)
VALUES
(1, 1, 3, 1, 1, 0, 'r1c1sA', NULL, '1', '1'), -- Seat in Section A
(2, 1, 4, 1, 1, 0, 'r1c2sA', NULL, '2', '1'), -- Another seat in Section A
(3, 1, 6, 1, 1, 0, 'r2c1sA', NULL, '1', '2'), -- Seat in Section A, Row 2
(4, 1, 7, 1, 1, 0, 'r2c2sA', NULL, '2', '2'), -- Seat in Section A, Row 2
(5, 1, 10, 2, 1, 0, 'r1c1sB', NULL, '1', '1'), -- Seat in Section B
(6, 1, 11, 2, 1, 0, 'r1c2sB', NULL, '2', '1'), -- Another seat in Section B
(7, 1, 13, 2, 1, 0, 'r2c1sB', NULL, '1', '2'), -- Seat in Section B, Row 2
(8, 1, 14, 2, 1, 0, 'r2c2sB', NULL, '2', '2'), -- Seat in Section B, Row 2
(9, 1, 17, 3, 1, 0, 'r1c1sC', NULL, '1', '1'), -- Seat in Section C
(10, 1, 18, 3, 1, 0, 'r1c2sC', NULL, '2', '1'), -- Another seat in Section C
(11, 1, 20, 3, 1, 0, 'r2c1sC', NULL, '1', '2'), -- Seat in Section C, Row 2
(12, 1, 21, 3, 1, 0, 'r2c2sC', NULL, '2', '2'), -- Seat in Section C, Row 2
(13, 1, 24, 4, 1, 0, 'r1c1sD', NULL, '1', '1'), -- Seat in Section D
(14, 1, 25, 4, 1, 0, 'r1c2sD', NULL, '2', '1'), -- Another seat in Section D
(15, 1, 27, 4, 1, 0, 'r2c1sD', NULL, '1', '2'), -- Seat in Section D, Row 2
(16, 1, 28, 4, 1, 0, 'r2c2sD', NULL, '2', '2'); -- Seat in Section D, Row 2

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
