DROP TABLE IF EXISTS device;
CREATE TABLE public.device
(
  id serial,
  name character varying(20),
  type character varying(10),
  status integer,
  CONSTRAINT device_pkey PRIMARY KEY (id)
);

INSERT INTO public.device(name, type, status)VALUES ('邹洋','A类', 1);
INSERT INTO public.device(name, type, status)VALUES ('机器','B类', 1);