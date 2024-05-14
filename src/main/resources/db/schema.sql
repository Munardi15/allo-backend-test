-- Create database
CREATE DATABASE pemilu;

-- Use the database
USE pemilu;

-- Create table Partai
CREATE TABLE
    partai (
        id BINARY(16) PRIMARY KEY,
        namaPartai VARCHAR(255) NOT NULL,
        nomorUrut INT NOT NULL
    );

-- Create table Dapil
CREATE TABLE
    dapil (
        id BINARY(16) PRIMARY KEY,
        namaDapil VARCHAR(255) NOT NULL,
        provinsi VARCHAR(255),
        jumlahKursi INT
    );

-- Create table Caleg
CREATE TABLE
    caleg (
        id BINARY(16) PRIMARY KEY,
        nama VARCHAR(255) NOT NULL,
        nomor_urut INT NOT NULL,
        partai_id BINARY(16),
        dapil_id BINARY(16),
        FOREIGN KEY (partai_id) REFERENCES partai (id),
        FOREIGN KEY (dapil_id) REFERENCES dapil (id)
    );

-- Insert data into Partai
INSERT INTO
    partai (id, nama_partai, nomor_urut)
VALUES
    (UUID (), 'Partai A', 1),
    (UUID (), 'Partai B', 2);

-- Insert data into Dapil
INSERT INTO
    dapil (id, nama_dapil, provinsi, jumlah_kursi)
VALUES
    (UUID (), 'Dapil 1', 'Provinsi A', 10),
    (UUID (), 'Dapil 2', 'Provinsi B', 15);

-- Insert data into Caleg
INSERT INTO
    caleg (id, nama, nomor_urut, partai_id, dapil_id)
VALUES
    (
        UUID (),
        'Caleg 1',
        1,
        (
            SELECT
                id
            FROM
                partai
            WHERE
                nama_partai = 'Partai A'
            LIMIT
                1
        ),
        (
            SELECT
                id
            FROM
                dapil
            WHERE
                nama_dapil = 'Dapil 1'
            LIMIT
                1
        )
    ),
    (
        UUID (),
        'Caleg 2',
        2,
        (
            SELECT
                id
            FROM
                partai
            WHERE
                nama_partai = 'Partai B'
            LIMIT
                1
        ),
        (
            SELECT
                id
            FROM
                dapil
            WHERE
                nama_dapil = 'Dapil 1'
            LIMIT
                1
        )
    ),
    (
        UUID (),
        'Caleg 3',
        3,
        (
            SELECT
                id
            FROM
                partai
            WHERE
                nama_partai = 'Partai A'
            LIMIT
                1
        ),
        (
            SELECT
                id
            FROM
                dapil
            WHERE
                nama_dapil = 'Dapil 2'
            LIMIT
                1
        )
    ),
    (
        UUID (),
        'Caleg 4',
        4,
        (
            SELECT
                id
            FROM
                partai
            WHERE
                nama_partai = 'Partai B'
            LIMIT
                1
        ),
        (
            SELECT
                id
            FROM
                dapil
            WHERE
                nama_dapil = 'Dapil 2'
            LIMIT
                1
        )
    );