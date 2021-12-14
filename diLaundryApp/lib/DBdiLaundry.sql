create table pegawai(
	id_pegawai serial primary key,
	nama_pegawai varchar (30) not null,
	username varchar (12) not null,
	password varchar (12) not null,
	email varchar (30) not null,
	no_telp varchar (12) not null
);

create table toko(
	nama_toko varchar (15) not null,
	no_telp_toko varchar (12) not null,
	alamat_toko varchar (30) not null,
	desa_toko varchar (15) not null,
	kecamatan_toko varchar (15) not null,
	kabupaten_toko varchar (15) not null,
	slogan text not null
);

insert into toko (nama_toko, no_telp_toko, alamat_toko, desa_toko, kecamatan_toko, kabupaten_toko, slogan)
values ('diLaundry','081233768809', 'Jln. Kartini No.144', 'Wonorejo', 'Kencong', 'Jember', 'Baju kamu kotor? Jangan lupa diLaundry ya!')

create table pewangi(
	id_pewangi serial primary key,
	nama_pewangi varchar (10) not null
);

insert into pewangi (nama_pewangi)
values ('Angel'), ('Vanilla'), ('Rose')

create table pelanggan(
	id_pelanggan serial primary key,
	nama_pelanggan varchar (30) not null,
	no_telp_pelanggan varchar (12) not null,
	alamat_pelanggan varchar (30) not null
);

create table jenis_laundry(
	id_jenis serial primary key,
	nama_jenis varchar (15) not null,
	harga_jenis double precision not null
);


insert into jenis_laundry (nama_jenis, harga_jenis)
values ('Cuci Kering','6000'), ('Cuci Setrika', '8000')

create table detail_laundry (
	id_transaksi smallserial primary key,
	tanggal_laundry date not null,
	berat_laundry numeric(2, 1) not null,
	id_jenis int not null,
	id_pewangi int not null,
	id_pelanggan int not null,
	id_pegawai int not null,
	constraint id_jenis foreign key(id_jenis) references jenis_laundry(id_jenis),
	constraint id_pewangi foreign key(id_pewangi) references pewangi(id_pewangi),
	constraint id_pelanggan foreign key(id_pelanggan) references pelanggan(id_pelanggan),
	constraint id_pegawai foreign key(id_pegawai) references pegawai(id_pegawai)
);
