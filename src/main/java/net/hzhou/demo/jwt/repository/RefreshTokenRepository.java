package net.hzhou.demo.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import net.hzhou.demo.jwt.entity.RefreshToken;

public interface RefreshTokenRepository
    extends JpaRepository<RefreshToken, Integer>, JpaSpecificationExecutor<RefreshToken> {
  Optional<RefreshToken> findByUserIdAndRefreshToken(Integer userId, String refreshToken);

  void deleteAllByUserId(Integer userId);
}
