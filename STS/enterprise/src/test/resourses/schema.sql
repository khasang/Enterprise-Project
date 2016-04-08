INSERT INTO client VALUES (1, 'description', 'Name of Company', 'PersonName', 'er@yt.ty', 1, 'ClientLogin', 'clientpassword', '8960315147' );
INSERT INTO client VALUES (2,'description1', 'Name of Company1', 'PersonName1', 'er1@yt.ty', 1, 'ClientLogin1', 'clientpassword1', '89603151471' );
INSERT INTO client VALUES (3,'description2', 'Name of Company2', 'PersonName2', 'er2@yt.ty', 1, 'ClientLogin2', 'clientpassword2', '89603151472' );
INSERT INTO client VALUES (4,'description3', 'Name of Company3', 'PersonName3', 'er3@yt.ty', 1, 'ClientLogin3', 'clientpassword3', '89603151473' );

INSERT INTO client_role VALUES (1,'BUYER', 1);
INSERT INTO client_role VALUES (2,'BUYER', 2);
INSERT INTO client_role VALUES (3,'CUSTOMER', 3);
INSERT INTO client_role VALUES (4,'CUSTOMER', 4);

INSERT INTO employee VALUES (1, 'Wash.street-18', '30', 'DEVELOPMENT', 'er@yt.ty', 1, '2000-01-01', 'BondJamesAlekseevich', '2000-01-01', 'employeelogin', 'employepassword', '50000.00', '1500.00');
INSERT INTO employee VALUES (2, 'Wash.street-15', '20', 'QA', 'er@yt.ty', 1, '2000-01-01', 'BondJamesAlekseevich', '2001-01-01', 'employeelogin1', 'employepassword1', '90000.00', '2500.00');
INSERT INTO employee VALUES (3, 'Wash.street-16', '70', 'DESIGN', 'er@yt.ty', 1, '2000-01-01', 'BondJamesAlekseevich', '2002-01-01', 'employeelogin2', 'employepassword2', '70000.00', '2500.00');
INSERT INTO employee VALUES (4, 'Wash.street-11', '70', 'MANAGEMENT', 'er@yt.ty', 1, '2000-01-01', 'BondJamesAlekseevich', '2003-01-01', 'employeelogin3', 'employepassword3', '80000.00', '3500.00');

INSERT INTO employee_role VALUES (1,'ADMIN', 1);
INSERT INTO employee_role VALUES (2,'EMPLOYEE', 2);
INSERT INTO employee_role VALUES (3,'EMPLOYEE', 3);
INSERT INTO employee_role VALUES (4,'EMPLOYEE', 4);

INSERT INTO project VALUES (1, '2000-01-01', 'ProjectDescription', '2016-01-01', '2000.00', 'PORTFOLIO', 'SuperProject1', 1);
INSERT INTO project VALUES (2, '2001-01-01', 'ProjectDescription1', '2016-01-01', '3000.00', 'SOCIALNETWORK', 'SuperProject2', 3);
INSERT INTO project VALUES (3, '2002-01-01', 'ProjectDescription2', '2016-01-01', '4000.00', 'BLOG', 'SuperProject3', 2);
INSERT INTO project VALUES (4, '2003-01-01', 'ProjectDescription3', '2016-01-01', '5000.00', 'FORUM', 'SuperProject4', 4);

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

