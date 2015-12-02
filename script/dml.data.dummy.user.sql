INSERT INTO user (username, password, real_name, age, phone)
  VALUE
  ('admin',
   sha2(concat('!a1@B2c3D4e5F6g7', 'admin', '#h4$I5j6K7l8M9n0'), 256),
   'admin',
   3,
   NULL
  );

INSERT INTO user (username, password, real_name, age, phone)
  VALUE
  (#{username},
   sha2(concat('!a1@B2c3D4e5F6g7', #{password}, '#h4$I5j6K7l8M9n0'), 256),
   #{realName},
   #{age},
   #{phone}
  );