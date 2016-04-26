INSERT INTO client VALUES (1, 'ClientLogin', 'clientpassword', 'description1', 'NameOfCompany', 'ContactPersonName1', 'er@yt.ty', 1,'8960315147');
INSERT INTO client VALUES (2, 'ClientLogin1', 'clientpassword1', 'description2', 'NameOfCompany2', 'ContactPersonName2', 'er1@yt.ty', 1, '89603151471');
INSERT INTO client VALUES (3, 'ClientLogin2', 'clientpassword2', 'description3', 'NameOfCompany3', 'ContactPersonName3', 'er2@yt.ty', 1, '89603151472');
INSERT INTO client VALUES (4, 'ClientLogin3', 'clientpassword3', 'description4', 'NameOfCompany4', 'ContactPersonName4', 'er3@yt.ty', 1, '89603151473');

INSERT INTO client_role VALUES (1,'ROLE_CLIENT', 1);
INSERT INTO client_role VALUES (2,'ROLE_CLIENT', 2);
INSERT INTO client_role VALUES (3,'ROLE_CLIENT', 3);
INSERT INTO client_role VALUES (4,'ROLE_CLIENT', 4);

INSERT INTO employee VALUES (1, 'employeelogin', 'employeepassword', 'Wash.street-18', '30', 'DEVELOPMENT', 'er@yt.ty', 1, '2000-01-01', 'BondJamesAlekseevich', '2000-01-01','50000.00', '1500.00');
INSERT INTO employee VALUES (2, 'employeelogin2', 'employeepassword1', 'Wash.street-15', '20', 'QA', 'er2@yt.ty', 1, '2001-01-01', 'BondJamesAlekseevich1', '2001-01-01', '90000.00', '2500.00');
INSERT INTO employee VALUES (3, 'employeelogin3', 'employeepassword2', 'Wash.street-16', '70', 'DESIGN', 'er3@yt.ty', 1, '2005-01-01', 'BondJamesAlekseevich2', '2002-01-01', '70000.00', '2500.00');
INSERT INTO employee VALUES (4, 'employeelogin4', 'employeepassword3', 'Wash.street-11', '70', 'MANAGEMENT', 'er4@yt.ty', 4, '2007-01-01', 'BondJamesAlekseevich3', '2003-01-01', '80000.00', '3500.00');

INSERT INTO employee_role VALUES (1,'ROLE_ADMIN', 1);
INSERT INTO employee_role VALUES (2,'ROLE_EMPLOYEE', 2);
INSERT INTO employee_role VALUES (3,'ROLE_EMPLOYEE', 3);
INSERT INTO employee_role VALUES (4,'ROLE_ADMIN', 4);

INSERT INTO project VALUES (1, '2000-01-01', 'ProjectDescription', '2016-01-01', '2000.00', 'PORTFOLIO', 'SuperProject1', 1);
INSERT INTO project VALUES (2, '2001-01-01', 'ProjectDescription1', '2016-01-01', '3000.00', 'SOCIALNETWORK', 'SuperProject2', 3);
INSERT INTO project VALUES (3, '2002-01-01', 'ProjectDescription2', '2016-01-01', '4000.00', 'BLOG', 'SuperProject3', 2);
INSERT INTO project VALUES (4, '2003-01-01', 'ProjectDescription3', NULL , '5000.00', 'FORUM', 'SuperProject4', 4);

INSERT INTO customer_order VALUES (1, 'PHOTOGALLERY', 2);
INSERT INTO customer_order VALUES (2, 'ONLINEPAYMENTS', 3);
INSERT INTO customer_order VALUES (3, 'LIVECHAT', 1);
INSERT INTO customer_order VALUES (4, 'EMAILFORMS', 4);

INSERT INTO offer VALUES (1, 'OfferDescription', '555.55', 'OfferTitle');
INSERT INTO offer VALUES (2, 'OfferDescription1', '111.55', 'OfferTitle1');
INSERT INTO offer VALUES (3, 'OfferDescription2', '222.55', 'OfferTitle2');
INSERT INTO offer VALUES (4, 'OfferDescription3', '333.55', 'OfferTitle3');

INSERT INTO news VALUES (1, 'NewsAuthor', 'NewsContent', 'NewsDescription', '2014-12-12', 'NewsTitle');
INSERT INTO news VALUES (2, 'NewsAuthor1', 'NewsContent1', 'NewsDescription', '2015-12-12', 'NewsTitle1');
INSERT INTO news VALUES (3, 'NewsAuthor2', 'NewsContent2', 'NewsDescription', '2013-12-12', 'NewsTitle2');
INSERT INTO news VALUES (4, 'NewsAuthor3', 'NewsContent3', 'NewsDescription', '2012-12-12', 'NewsTitle3');

INSERT INTO track VALUES (1, 'TrackDescription1', 10, 'RUNNING', 1, 1);
INSERT INTO track VALUES (2, 'TrackDescription2', 100, 'RUNNING', 1, 1);
INSERT INTO track VALUES (3, 'TrackDescription3', 20, 'CONFIRMED', 2, 2);
INSERT INTO track VALUES (4, 'TrackDescription4', 70, 'RUNNING', 2, 2);